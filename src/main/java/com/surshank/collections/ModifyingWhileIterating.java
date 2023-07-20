package com.surshank.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class ModifyingWhileIterating {
  public static void main(String[] args){
    Room presidential = new Room("Presidential", 500.00);
    Room king = new Room("King", 250.00);
    Room queen = new Room("Queen", 200.00);

    Collection<Room> rooms = new ArrayList<>(Arrays.asList(presidential, king, queen));

    Collection<Room> roomsCopy = new ArrayList<>(rooms);
    approach1(roomsCopy);
    roomsCopy = new ArrayList<>(rooms);
    approach2(roomsCopy);
  }

  public static void approach1(Collection<Room> rooms) {
    try {
      for (Room room : rooms) {
        if (room.getName().equals("King")) {
          rooms.remove(room);
        }
      }
    } catch (ConcurrentModificationException e) {
      System.out.println("Expected: "+ e.toString());
    }

    System.out.println("The actual issue - will fail without the try-catch:");
    rooms.forEach(r -> System.out.println(r.getName()));
  }

  public static void approach2(Collection<Room> rooms) {
    // Better option is to copy the collection OR use an iterator
    Iterator<Room> iterator = rooms.iterator();
    while (iterator.hasNext()) {
      Room room = iterator.next();
      if (room.getName().equals("King")) {
        System.out.println("Removing King...");
        iterator.remove(); // IMPORTANT
      }
    }

    System.out.println("With Iterator:");
    rooms.forEach(r -> System.out.println(r.getName()));
  }
}
