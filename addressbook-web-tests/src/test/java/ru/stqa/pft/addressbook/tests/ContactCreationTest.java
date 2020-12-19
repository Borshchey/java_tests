package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goToHome();
    Contacts before = app.contact().all();
    app.contact().addNewContact();
    File photo = new File("src/test/resources/img.png");
    ContactData contact = new ContactData()
            .withLastname("Borshch")
            .withFirstname("Elizaveta")
            .withCompanyName("JustAI")
            .withEmail("test@example.com")
            .withGroup("test2")
            .withPhoto(photo);
    app.contact().fillContactForm(contact, true);
    app.contact().submitContactCreation();
    app.goToHome();
/*    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
*/
  }


  /* Вспомогателный тест для проверки текущей директории, наличия файла и пр
  @Test
  public void testCurrentDirectory() {
    File currentDir = new File(".");
    File photo = new File("src/test/resources/img.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
*/
}