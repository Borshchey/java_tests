package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().List();
    GroupData group = new GroupData().withName("test6");
    app.group().create(group);
    List<GroupData> after = app.group().List();
    Assert.assertEquals(after.size(), before.size() + 1);



 /*   int max = 0;
    for (GroupData q : after) {
      if (q.getId() > max) {
        max = q.getId();
      }
    }
  */

    //лямбда-выражение (анонимная функция сравнения для вычисления максимального идентификатора)
 //   group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
