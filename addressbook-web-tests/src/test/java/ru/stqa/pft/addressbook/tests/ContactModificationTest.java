package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.goToHome();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com"));
    app.getContactHelper().updateContact();

  }
}
