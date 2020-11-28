package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion() {
    app.goToHome();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()){
       app.getContactHelper().createContact(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test6"), true);

     }
    app.goToHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.skipAlert();
    app.goToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before -1);
  }

}
