package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.TestData;
import models.User;
import play.libs.Json;
import play.mvc.*;

public class Application extends Controller {

    /**
     * Convert java object to json
     * Curl command: curl http://localhost:9000/toJson
     */
    public static Result toJson() {
        User user = TestData.userOprah;
        JsonNode json = Json.toJson(user);
        return ok("user: " + Json.stringify(json));
    }

    /**
     * Convert java object to json and traverse the json to find the 'username' element in the json.
     * 'username' is the first element in the json tree.
     * @param success if query parameter success is false the error case will be handled. Default is true.
     * Curl command: curl http://localhost:9000/username
     */
    public static Result getUsername(Boolean success) {
        String searchText = (success) ? "username" : "userName";
        User user = TestData.userOprah;
        JsonNode jsonUser = Json.toJson(user);
        JsonNode username = jsonUser.findValue(searchText);
        // Jackson returns 'null' if the element was not found
        if(username != null)
            return ok("username: " + username.textValue());
        else
            return badRequest("Couldn't retrieve a username");
    }

    /**
     * Convert java object to json and traverse the json to find the 'address' element in the json.
     * 'address' is a nested object in the json tree and is a custom value object.
     * @param success if query parameter success is false the error case will be handled. Default is true.
     * Curl command: http://localhost:9000/address
     */
    public static Result getAddress(Boolean success) {
        String searchText = (success) ? "address" : "Address";
        User user = TestData.userOprah;
        JsonNode jsonUser = Json.toJson(user);
        JsonNode jsonAddress = jsonUser.findValue(searchText);
        // Jackson returns 'null' if the element was not found
        if(jsonAddress != null)
            return ok("address: " + Json.stringify(jsonAddress));
        else
            return badRequest("Couldn't retrieve an address");
    }

    /**
     * Convert java object to json and traverse the json to find the 'messages' element in the json.
     * 'messages' is a nested array in the json tree which contains multiple message entries.
     * Curl command: http://localhost:9000/messages
     */
    public static Result getMessages() {
        User user = TestData.userOprah;
        JsonNode messages = Json.toJson(user).findValue("messages");
        return ok("messages: " + Json.stringify(messages));
    }

    /**
     * Convert java object to json, traverse the json to find the 'messages' element and then access the json array by index.
     * 'messages' is a nested array in the json tree which contains multiple message entries.
     * Only one message in the array is returned.
     * Curl command: http://localhost:9000/messages/1
     */
    public static Result getMessageById(Integer id) {
        User user = TestData.userOprah;
        JsonNode message = Json.toJson(user).findValue("messages").get(id);
        return ok("message: " + Json.stringify(message));
    }

    /**
     * Convert json (send via HTTP POST) to user object.
     * Curl command: curl --header "Content-type: application/json" --request POST --data '{"username":"oprah","pa33","profileInfo":{"firstName":"Oprah","lastName":"Winfrey","age":61,"address":{"street":"1474MountainDrive","zipCode":"93108","city":"Montecito","country":"United States"}},"messages":[{"id":0,"text":"My first message"},{"id":1,"text":"What a great day!"},{"id":2,"text":"Good night!"}]}' http://localhost:9000/fromJson
     */
    @BodyParser.Of(BodyParser.Json.class)
    public static Result fromJson() {
        JsonNode json = request().body().asJson();
        User user = Json.fromJson(json, User.class);
        if(user != null)
            return ok(Json.newObject().put("success", true));
        else
            return badRequest("The body couldn't be parsed to a user: " + json);
    }

}
