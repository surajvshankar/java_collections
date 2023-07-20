package com.surshank.collections;

import java.util.ArrayList;
import java.util.List;


public class Lists {
  public static void main(String[] args) {
    List<String> sample = new ArrayList<>();
    sample.add("a");
    try {
      sample.add(2, "b");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Least size");
    }
    sample.add(1, "b");
    sample.add(2, "d");
    sample.add(2, "c");

    sample.forEach(System.out::println);
    System.out.println();

    String gotBack = sample.set(2, "e");
    sample.forEach(System.out::println);
    System.out.println(gotBack);
    System.out.println();

    System.out.println(sample.get(1));

    sample.add("e");
    System.out.println(sample.indexOf("e"));
    System.out.println();

    String whatWasRemoved = sample.remove(1);
    System.out.println(whatWasRemoved);
  }
}
