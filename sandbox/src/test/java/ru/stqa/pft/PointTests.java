package ru.stqa.pft;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void firstTest() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  @Test
  public void secondTest() {
    Point p1 = new Point(-1, -8);
    Point p2 = new Point(-1, -8);
    Assert.assertEquals(p1.distance(p2), 0);
  }

  @Test
  public void thirdTest() {
    Point p1 = new Point(-1, -8);
    Point p2 = new Point(-1, -8);
    Assert.assertNotEquals(p1.distance(p2), 5);
  }
}
