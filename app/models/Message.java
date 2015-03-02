package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

  private final Long id;

  private final String text;

  @JsonCreator
  public Message(@JsonProperty("id") Long id,
                 @JsonProperty("text") String text) {
    this.id = id;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return "Message{" +
      "id=" + id +
      ", text='" + text + '\'' +
      '}';
  }
}
