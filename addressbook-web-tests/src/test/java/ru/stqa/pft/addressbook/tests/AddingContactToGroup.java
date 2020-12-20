package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddingContactToGroup  extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {

    app.goToHomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().createContact((new ContactData().withFirstname("Contact_1").withLastname("Added_1")), true);
      app.contact().returnToHomePage();
    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group_1"));
      app.contact().returnToHomePage();
    }
  }

  @Test
  public void testAddContactToGroup() {

    Contacts beforeContacts = app.db().contacts();
    ContactData contactAdded = beforeContacts.iterator().next();
    Groups beforeGroups = app.db().groups();
    GroupData modifiedGroup = beforeGroups.iterator().next();

    app.goToHomePage();
    if (!contactAdded.getGroups().isEmpty() && contactAdded.getGroups().contains(modifiedGroup)) {
      app.contact().removeContactFromGroup(contactAdded, modifiedGroup);
      assertThat(contactAdded.getGroups().without(modifiedGroup), equalTo(app.db().contacts().stream()
              .filter((c) -> c.getId() == contactAdded.getId()).collect(Collectors.toList()).get(0).getGroups()));

      app.contact().returnToHomePage();
    }
    app.contact().selectDisplayGroup("[all]");
    app.contact().addContactToGroup(contactAdded, modifiedGroup);
    app.contact().returnToHomePage();
    assertThat(contactAdded.getGroups().withAdded(modifiedGroup), equalTo(app.db().contacts().stream()
            .filter((c) -> c.getId() == contactAdded.getId()).collect(Collectors.toList()).get(0).getGroups()));


  }
}

