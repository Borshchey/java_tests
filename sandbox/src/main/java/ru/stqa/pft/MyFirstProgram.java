package ru.stqa.pft;

import java.sql.SQLOutput;

public class MyFirstProgram {
    public static void main (String[] args) {
        Square s = new Square(5);
        s.l = 5;
        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

        Rectangle r = new Rectangle(4,6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());


        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        System.out.println("Расстояние между точками равно " + distance(p1,p2));
    }

    public static double distance(Point p1, Point p2) {
       return Math.sqrt(Math.pow((p2.x - p1.x),2) + Math.pow((p2.y - p2.y),2));
    }
}
