package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    attach(By.name("photo"), contactData.getPhoto());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void addNewContact() {
    click(By.linkText("add new"));
  }
  /* public void editContact() {
    click(By.xpath("(//img[@alt='Edit'])"));
  } */

  public void editContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  private void editContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void selectContact(int index) {
    click(By.name("selected[]"));
  }

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void modifyContact(ContactData contact) {
 //   selectContactById(contact.getId());
    editContactModificationById(contact.getId());
    fillContactForm(contact, false);
    updateContact();
    contactCache = null;
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      String address = element.findElement(By.xpath("td[4]")).getText();
      String allEmail = element.findElement(By.xpath("td[5]")).getText();
      String allPhones = element.findElement(By.xpath("td[6]")).getText();
      contactCache.add(new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAddress(address).withAllEmail(allEmail));
    }
    return new Contacts(contactCache);
  }

  public Set<ContactData> all2() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones));
    }
    return contacts;
  }


  public ContactData InfoFromEditForm(ContactData contact) {
    editContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withAddress(address)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }


  }

