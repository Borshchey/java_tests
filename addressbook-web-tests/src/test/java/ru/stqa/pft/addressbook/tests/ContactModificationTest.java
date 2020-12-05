package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

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
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Borshch", "Elizaveta", "JustAI", "test1@example.com", null), false);
    app.getContactHelper().updateContact();
    app.goToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

  }
}