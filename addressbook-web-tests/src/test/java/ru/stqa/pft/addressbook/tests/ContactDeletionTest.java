package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goToHome();
    if ( app.contact().list().size()==0){
      app.contact().createContact(new ContactData("Borshch", "Elizaveta", "JustAI", "test@example.com", "test2"), true);

    }
  }

  @Test (enabled = false)
  public void testContactDeletion() {

    List<ContactData> before = app.contact().list();
    app.goToHome();
    int index = before.size() -1;
    app.contact().delete(index);
    app.skipAlert();
    app.goToHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(index);
    Assert.assertEquals(before, after);

  }


}