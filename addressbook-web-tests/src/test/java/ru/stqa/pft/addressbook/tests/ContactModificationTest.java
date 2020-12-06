package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goToHome();
    if (app.contact().list().size()==0){
      app.contact().createContact(new ContactData()
              .withLastname("Borshch")
              .withFirstname("Elizaveta")
              .withCompanyName("JustAI")
              .withEmail("test@example.com")
              .withGroup("test2"), true);
    }
  }

  @Test (enabled = true)
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    app.goToHome();
    int index = before.size() -1;
    ContactData contact = new ContactData().withId(before.get(index).getId())
            .withLastname("Borshch")
            .withFirstname("Elizaveta")
            .withCompanyName("JustAI")
            .withEmail("test1@example.com");

    app.contact().modifyContact(index, contact);
    app.goToHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}

