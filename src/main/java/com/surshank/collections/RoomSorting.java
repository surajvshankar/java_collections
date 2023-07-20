package com.surshank.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RoomSorting {
  static Room room1 = new Room("Presidential Suite", 1550);
  static Room room2 = new Room("King", 525);
  static Room room3 = new Room("Presidential Suite", 500);

  static List<Room> rooms = Arrays.asList(room1, room2, room3);


  static SortableRoom sortableRoom1 = new SortableRoom("Presidential Suite", 1550);
  static SortableRoom sortableRoom2 = new SortableRoom("King", 525);
  static SortableRoom sortableRoom3 = new SortableRoom("Presidential Suite", 500);

  static List<SortableRoom> sortableRooms = new ArrayList<>(Arrays.asList(sortableRoom1, sortableRoom2, sortableRoom3));

  public static void main(String[] args) {
    // Room cannot be cast to java.lang.Comparable
    //	at java.util.Comparators$NaturalOrderComparator.compare(Comparators.java:47)
    // Needs to implement Comparable interface
    // rooms.stream().sorted().map(Room::getName).forEach(System.out::println);

    System.out.println("Default:");
    sortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    List<SortableRoom> copyOfSortableRooms = new ArrayList<>(sortableRooms);
    Collections.sort(copyOfSortableRooms);
    System.out.println("Using a Comparable Implementation for Natural Sort Order:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    copyOfSortableRooms = new ArrayList<>(sortableRooms);
    Collections.sort(copyOfSortableRooms, Comparator.naturalOrder());
    System.out.println("Natural order:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    copyOfSortableRooms = new ArrayList<>(sortableRooms);
    copyOfSortableRooms.sort(Comparator.naturalOrder());
    System.out.println("Directly using the List.sort - newer versions of Jave:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    copyOfSortableRooms = new ArrayList<>(sortableRooms);
    copyOfSortableRooms.sort(SortableRoom.RATE_COMPARATOR);
    System.out.println("Using a Global comparator:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    copyOfSortableRooms = new ArrayList<>(sortableRooms);
    copyOfSortableRooms.sort(SortableRoom.CHAINED_COMPARATOR);
    System.out.println("Using a Chained global comparator:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    copyOfSortableRooms = new ArrayList<>(sortableRooms);
    copyOfSortableRooms.sort(SortableRoom.CHAINED_COMPARATOR.reversed());
    System.out.println("Using a Reversed chained global comparator:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));
    System.out.println();

    searching();
  }

  public static void searching(){
    List<SortableRoom> copyOfSortableRooms = new ArrayList<>(sortableRooms);
    copyOfSortableRooms.sort(SortableRoom.RATE_COMPARATOR);

    int result = Collections.binarySearch(copyOfSortableRooms,  sortableRoom3, SortableRoom.RATE_COMPARATOR);
    System.out.println("Index: " + result);
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));
    System.out.println();

    SortableRoom sortableRoom4 = new SortableRoom("New room", 550);
    result = Collections.binarySearch(copyOfSortableRooms,  sortableRoom4, SortableRoom.RATE_COMPARATOR);
    System.out.println("Index: " + result);
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    // Adding it
    copyOfSortableRooms.add(Math.abs(++result), sortableRoom4);
    System.out.println("After adding 'New Room':");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));
    System.out.println();


    SortableRoom sortableRoom5 = new SortableRoom("New room", 1550);
    copyOfSortableRooms = new ArrayList<>(sortableRooms);
    copyOfSortableRooms.sort(SortableRoom.CHAINED_COMPARATOR);
    result = Collections.binarySearch(copyOfSortableRooms,  sortableRoom5, SortableRoom.CHAINED_COMPARATOR);
    copyOfSortableRooms.add(Math.abs(++result), sortableRoom5);
    System.out.println("After adding 'New Room' with CHAINED_COMPARATOR:");
    copyOfSortableRooms.forEach(r -> System.out.format("%s : %.2f%n", r.getName(), r.getRate()));

    System.out.println("Min: " + Collections.min(sortableRooms, SortableRoom.CHAINED_COMPARATOR).getName());
    System.out.println("Max: " + Collections.max(sortableRooms, SortableRoom.CHAINED_COMPARATOR).getName());
  }
}
