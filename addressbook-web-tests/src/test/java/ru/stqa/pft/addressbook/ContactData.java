package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String companyName;
  private final String email;

  public ContactData(String firstname, String lastname, String companyName, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.companyName = companyName;
    this.email = email;
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
}
