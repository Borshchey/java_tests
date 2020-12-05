package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goToHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test2"), true);
    app.getContactHelper().submitContactCreation();
    app.goToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);
    app.logout();
  }

}