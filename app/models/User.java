package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * User value object.
 * @JsonCreator and @JsonProperty tell Jackson how to parse this value object to json.
 * Each nested custom object needs to use @JsonCreator and @JsonProperty as well.
 */
public class User {

  private final String username;

  private final String password;

  private final ProfileInfo profileInfo;

  private final List<Message> messages;

  @JsonCreator
  public User(@JsonProperty("username") String username,
              @JsonProperty("password") String password,
              @JsonProperty("profileInfo") ProfileInfo profileInfo,
              @JsonProperty("messages") List<Message> messages) {
    this.username = username;
    this.password = password;
    this.profileInfo = profileInfo;
    this.messages = messages;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public ProfileInfo getProfileInfo() {
    return profileInfo;
  }

  public List<Message> getMessages() {
    return messages;
  }

  @Override
  public String toString() {
    return "User{" +
      "username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", profileInfo=" + profileInfo +
      ", messages=" + messages +
      '}';
  }
}
