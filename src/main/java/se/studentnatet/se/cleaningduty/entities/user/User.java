package se.studentnatet.se.cleaningduty.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.csv.CSVRecord;

public class User {
  @JsonProperty("first_name")
  public final String firstName;

  @JsonProperty("last_name")
  public final String lastName;

  @JsonProperty("login")
  public final String login;

  /**
   * Build a User from a {@link CSVRecord}
   *
   * @param record
   * @return
   */
  public User(CSVRecord record) {
    firstName = record.get("firstname");
    lastName = record.get("lastname");
    login = record.get("login");
  }
}
