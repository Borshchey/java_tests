package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goToHomePage();
    if (app.db().contacts().size() == 0){
      app.contact().createContact(new ContactData()
              .withLastname("Borshch")
              .withFirstname("Elizaveta")
              .withCompanyName("JustAI")
              .withEmail("test@example.com"), true);
    //          .withGroup("test2"), true);
    }
  }

  @Test (enabled = true)
  public void testContactModification() {
    Contacts before = app.db().contacts();
    app.goToHomePage();
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withLastname("Borshch")
            .withFirstname("Elizaveta")
            .withCompanyName("JustAI")
            .withEmail("test1@example.com");

    app.contact().modifyContact(contact);
    app.goToHomePage();
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyGroupListInUI();

  }


}

