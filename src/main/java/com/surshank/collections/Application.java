package com.surshank.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class Application {
  public static void main(String[] args) {
    usingCollections();
    usingArrays();

    Guest john = new Guest("John", "Doe", false);
    Guest maria = new Guest("Maria", "Doe", false);
    Guest sonia = new Guest("Sonia", "Doe", true);
    Guest siri = new Guest("Siri", "Doe", true);

    List<Guest> guestList = new ArrayList<>();
    guestList.add(john);

    print(guestList);

    guestList.addAll(0, Arrays.asList(sonia, siri));
    print(guestList);
  }

  public static void print(List<Guest> guestList) {
    System.out.format("%n--List Contents--%n");

    for(int i = 0; i < guestList.size(); i++){
      Guest guest = guestList.get(i);
      System.out.format("%x: %s %n", i, guest.toString());
    }
  }

  public static void usingCollections() {
    Room room1 = new Room("Presidential Suite", 1550);
    Room room2 = new Room("King", 525);

    // Collection<Room> rooms = List.of(room1, room2);
    Collection<Room> rooms = Arrays.asList(room1, room2);

    double total = 0;
    // rooms.forEach(room -> {total = total + room.getRate(); });
    // Will error: Variable used in lambda expression should be final or effectively final
    // And will correct to:
    AtomicReference<Double> total2 = new AtomicReference<>((double) 0);
    rooms.forEach(room -> {
//      total2.updateAndGet(v -> new Double((double) (v + room.getRate())));
      total2.updateAndGet(v -> v + room.getRate());
    });
    System.out.println(total2.get());
    // Ofcourse:
    for (Room room : rooms) {
      total = total + room.getRate();
    }
    System.out.println(total);

    // BEST:
    //System.out.println(rooms.stream().mapToDouble(r -> r.getRate()).sum());
    System.out.println(rooms.stream().mapToDouble(Room::getRate).sum());
  }

  public static void usingArrays() {
    Room room1 = new Room("Presidential Suite", 1550);
    Room room2 = new Room("King", 525);

    Room[] rooms = new Room[2]; // You need to know the size
    rooms[0] = room1;
    rooms[1] = room2;

    // To extend an array, create a new one
    Room[] newArray = Arrays.copyOf(rooms, rooms.length + 2);

    for ( Room room : newArray) {
      if (room != null) {
        System.out.println(room.getName());
      }
    }
    System.out.println(newArray.length);
  }
}
