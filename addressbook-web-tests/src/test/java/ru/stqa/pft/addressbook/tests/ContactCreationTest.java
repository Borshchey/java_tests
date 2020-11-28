package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test6"), true);
    app.getContactHelper().submitContactCreation();
    app.logout();
  }

}
