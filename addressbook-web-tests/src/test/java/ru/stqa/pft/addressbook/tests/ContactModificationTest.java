package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.goToHome();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test6"), true);

    }
    app.goToHome();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Borshch", "Elizaveta", "JustAI", "test1@example.com", null), false);
    app.getContactHelper().updateContact();
    app.goToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);

  }
}
