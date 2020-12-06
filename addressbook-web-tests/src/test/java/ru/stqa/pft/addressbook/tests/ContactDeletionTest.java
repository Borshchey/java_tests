package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goToHome();
    if ( app.contact().all().size()==0){
      app.contact().createContact(new ContactData()
              .withLastname("Borshch")
              .withFirstname("Elizaveta")
              .withCompanyName("JustAI")
              .withEmail("test@example.com")
              .withGroup("test2"), true);
    }
  }

  @Test
  public void testContactDeletion() {

    Set<ContactData> before = app.contact().all();
    app.goToHome();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.skipAlert();
    app.goToHome();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);

  }


}