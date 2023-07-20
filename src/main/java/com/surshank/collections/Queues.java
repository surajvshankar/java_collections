package com.surshank.collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;


public class Queues {
  public static void main(String[] args) {
    usingSimpleArrayDeque();
    usingPriorityQueues();
  }

  public static void usingSimpleArrayDeque() {
    // Deque => Deck

    Guest john = new Guest("John", "Doe", false);

    Queue<Guest> checkinQueue = new ArrayDeque<>();
    try{
      Guest guest1 = checkinQueue.remove(); // Same for add (exception) vs offer (special value) and element vs peek
      System.out.println(guest1);
    } catch (NoSuchElementException e) {
      System.out.println("empty arraydeque");
    }
    Guest guest2 = checkinQueue.poll();
    System.out.println(guest2); // null

    checkinQueue.add(john);
    System.out.println(checkinQueue.peek()); // Does not remove
    System.out.println(checkinQueue.size());
    System.out.println(checkinQueue.poll()); // Removes
    System.out.println(checkinQueue.size());
  }

  public static void usingPriorityQueues() {
    Guest john = new Guest("John", "Doe", false);
    Guest maria = new Guest("Maria", "Doe", false);
    Guest sonia = new Guest("Sonia", "Doe", true);
    Guest siri = new Guest("Siri", "Doe", true);

    Comparator<Guest> comparator = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();

    Queue<Guest> checkinQueue = new PriorityQueue<>(comparator);
    checkinQueue.add(john);
    checkinQueue.add(maria);
    checkinQueue.add(sonia);
    checkinQueue.add(siri);

    checkinQueue.stream().map(Guest::getFirstName).forEach(System.out::println);
  }
}
