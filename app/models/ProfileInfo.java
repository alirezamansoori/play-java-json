package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileInfo {

  private final String firstName;

  private final String lastName;

  private final Integer age;

  private final Address address;

  @JsonCreator
  public ProfileInfo(@JsonProperty("firstName") String firstName,
                     @JsonProperty("lastName") String lastName,
                     @JsonProperty("age") Integer age,
                     @JsonProperty("address") Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public Address getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "ProfileInfo{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", age='" + age + '\'' +
      ", address=" + address +
      '}';
  }
}
