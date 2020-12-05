
package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String companyName;
  private final String email;
  private final String group;



  public ContactData(String id, String firstname, String lastname, String companyName, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.companyName = companyName;
    this.email = email;
    this.group = group;
  }

  public ContactData(String firstname, String lastname, String companyName, String email, String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.companyName = companyName;
    this.email = email;
    this.group = group;
  }

  public String getId() {
    return id;
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

  public String getGroup() {
    return group;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}