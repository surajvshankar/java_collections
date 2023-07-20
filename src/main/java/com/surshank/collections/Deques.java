package com.surshank.collections;

import java.util.ArrayDeque;
import java.util.Deque;


public class Deques {
  // Deque => Deck

  public static void main(String[] args) {
    stacking();
  }

  public static void stacking() {
    Guest john = new Guest("John", "Doe", false);
    Guest maria = new Guest("Maria", "Doe", false);
    Guest sonia = new Guest("Sonia", "Doe", true);
    Guest siri = new Guest("Siri", "Doe", true);

    Deque<Guest> asADeque = new ArrayDeque<>();
    asADeque.addFirst(john); // Bottom
    asADeque.addLast(maria);
    asADeque.push(sonia);  // Top

    asADeque.stream().map(Guest::getFirstName).forEach(System.out::println); // Notice that the print peeks from the top of the stack
    System.out.println();

    asADeque.pop();
    asADeque.stream().map(Guest::getFirstName).forEach(System.out::println);
  }

}
