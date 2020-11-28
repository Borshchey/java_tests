package ru.stqa.pft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

 /*   String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "Kotlin";
    langs[2] = "Python";
    langs[3] = "PHP"; */

    String[] langs = {"Java", "Kotlin", "Python", "PHP"};

    List<String > languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("Kotlin");
    languages.add("Php");

    List<String > languages2 = Arrays.asList("Java", "Kotlin", "Python", "PHP");


    for (String l : languages2) {
      System.out.println("Это " + l);
    }

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Это " + languages.get(i));

    }

 /*   for (int i = 0; i < langs.length; i++) {
      System.out.println("Это " + langs[i]);
    } */

  }

  public static void test(String[] args) {

    List languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("Kotlin");
    languages.add("Php");


    for (Object l : languages) {
      System.out.println("Это " + l);
    }
  }


}
