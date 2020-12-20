package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goToHome();
    if (app.db().contacts().size() == 0){
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

    Contacts before =  app.db().contacts();
    app.goToHome();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.skipAlert();
    app.goToHome();
    Contacts after =  app.db().contacts();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));

  }


}