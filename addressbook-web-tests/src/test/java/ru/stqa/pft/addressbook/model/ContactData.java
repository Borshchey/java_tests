package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String companyName;
  private final String email;
  private final String group;

  public ContactData(String firstname, String lastname, String companyName, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.companyName = companyName;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() { return group; }
}
