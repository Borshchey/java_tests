package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test  (enabled = false)
  public void testContactCreation() throws Exception {
    app.goToHome();
    List<ContactData> before = app.contact().list();
    app.contact().addNewContact();
    ContactData contact = new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test2");
    app.contact().fillContactForm(contact, true);
    app.contact().submitContactCreation();
    app.goToHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);

/*    int max = 0;
    for (ContactData q : after) {
      if (q.getId() > max) {
        max = q.getId();
      }
    }

    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

*/
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}