package ru.stqa.pft.addressbook.tests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class ContactCreationTest extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> groups = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    app.goToHome();
    Contacts before = app.db().contacts();
    app.contact().addNewContact();
 /*    File photo = new File("src/test/resources/img.png");
   ContactData contact = new ContactData()
            .withLastname("Borshch")
            .withFirstname("Elizaveta")
            .withCompanyName("JustAI")
            .withEmail("test@example.com")
            .withGroup("test2")
            .withPhoto(photo); */
    app.contact().fillContactForm(contact, true);
    app.contact().submitContactCreation();
    app.goToHome();
/*        Contacts after = app.db().contacts();
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