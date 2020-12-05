package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.goToHome();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test2"), true);

    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.goToHome();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    ContactData contact = new ContactData("Borshch", "Elizaveta", "JustAI", "test1@example.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().updateContact();
    app.goToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}