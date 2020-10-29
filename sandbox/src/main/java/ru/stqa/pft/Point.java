package ru.stqa.pft;

public class Point {
  public int x;
  public int y;

  public Point (int x, int y){
  this.x = x;
  this.y = y;
}
  public double distance() {
    return Math.sqrt(Math.pow((this.x - this.x),2) + Math.pow((this.y - this.y),2));
  }
}

