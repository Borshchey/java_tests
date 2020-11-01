package ru.stqa.pft;

public class Point {
  public int x;
  public int y;

  public Point (int x, int y){
  this.x = x;
  this.y = y;
}
  public double distance(Point p) {
    return Math.sqrt(Math.pow(Math.abs((p.x - this.x)),2) + Math.pow(Math.abs((p.y - this.y)),2));
  }
}

