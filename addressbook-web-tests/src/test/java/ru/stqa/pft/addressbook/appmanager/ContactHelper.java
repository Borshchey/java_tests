package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("email"), contactData.getEmail());
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void editContact() {
    click(By.xpath("(//img[@alt='Edit'])[2]"));
  }
  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void selectContact() {
    click(By.id("7"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
}
