package com.surshank.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;


public class Sets {
  public static void main(String[] args) {
    Set<Room> rooms = new HashSet<>();
    Room presidential = new Room("Presidential", 500.00);
    Room king = new Room("King", 250.00);

    rooms.add(presidential);
    rooms.add(king);
    rooms.add(presidential);
    rooms.add(new Room("Presidential", 500.00));

    rooms.stream().map(Room::getName).forEach(System.out::println);
    System.out.println(rooms.size()); // Should be two, unordered.

    // Cannot resolve method 'of' in 'Set'
    // Set<Room> immutablesRooms = Set.of(presidential, king);
    // Set<Room> immutablesRooms = Set.copyOf(rooms);

    List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 3000, 2000);
    NavigableSet<Integer> navigableSet = new TreeSet<>(numbers);

    System.out.println("Sorted (by default):");
    navigableSet.forEach(System.out::println);
    System.out.println("Reverse sorted:");
    navigableSet.descendingSet().forEach(System.out::println);

    System.out.println("Everything above:");
    navigableSet.tailSet(1750).forEach(System.out::println);

    System.out.println("Subset:");
    navigableSet.subSet(1750, 2750).forEach(System.out::println);

    System.out.format("Just higher: %d or lower: %d\n", navigableSet.higher(1750), navigableSet.lower(1750));
  }
}
