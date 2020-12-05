package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion() {
    app.goToHome();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test6"), true);

    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.goToHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.skipAlert();
    app.goToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -1);
  }

}