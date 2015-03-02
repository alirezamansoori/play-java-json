package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

  private final String street;

  private final String zipCode;

  private final String city;

  private final String country;

  @JsonCreator
  public Address(@JsonProperty("street") String street,
                 @JsonProperty("zipCode") String zipCode,
                 @JsonProperty("city") String city,
                 @JsonProperty("country") String country) {
    this.street = street;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
  }

  public String getStreet() {
    return street;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return "Address{" +
      "street='" + street + '\'' +
      ", zipCode='" + zipCode + '\'' +
      ", city='" + city + '\'' +
      ", country='" + country + '\'' +
      '}';
  }
}
