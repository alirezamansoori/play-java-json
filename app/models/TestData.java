package models;

import java.util.Arrays;
import java.util.List;

public class TestData {

  public static Address address = new Address("1474MountainDrive", "93108", "Montecito", "United States");
  public static ProfileInfo profileInfo = new ProfileInfo("Oprah", "Winfrey", 61, address);
  public static List<Message> messages = Arrays.asList(new Message(0l, "My first message"), new Message(1l, "What a great day!"), new Message(2l, "Good night!"));
  public static User userOprah = new User("oprah", "a2d8Had33", profileInfo, messages);
}
