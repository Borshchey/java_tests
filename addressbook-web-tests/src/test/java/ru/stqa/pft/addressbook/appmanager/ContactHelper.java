package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("email"), contactData.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void addNewContact() {
    click(By.linkText("add new"));
  }
  public void editContact() {
    click(By.xpath("(//img[@alt='Edit'])"));

  }

  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
  public void selectContact(int index) {
    click(By.name("selected[]"));
  }
  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
  public void createContact(ContactData contact, boolean creation) {
    addNewContact();
    fillContactForm(contact, creation);
    submitContactCreation();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      ContactData contact = new ContactData().withId(id)
          .withFirstname(firstname)
          .withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  public void modifyContact(int index, ContactData contact) {
    selectContact(index);
    editContact();
    fillContactForm(contact, false);
    updateContact();
  }


  public void delete(int index) {
    selectContact(index);
    deleteContact();
  }
}
