package com.surshank.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Streams {
  public static void main(String[] args) {
    Room presidential = new Room("Presidential", 500.00);
    Room king = new Room("King", 250.00);
    Room queen = new Room("Queen", 200.00);

    Collection<Room> rooms = new ArrayList<>(Arrays.asList(presidential, king, queen));

    rooms.stream()
        // Filter is an INTERMEDIATE operation
        .filter(new Predicate<Room>() {
            // Filter accepts a Predicate - which essentially has one method "test" that returns a bool
            @Override
            public boolean test(Room room) {
              return room.getName().equals("King");
            }
          })
      // forEach is a TERMINAL operation.
      // Without the terminal operation, the results of filter are ignored (unless assigned) - the input to the terminal operator is the output of filter!
      .forEach(new Consumer<Room>() {
          @Override
          public void accept(Room room) {
            System.out.println(room.getName() + " : " + room.getRate());
          }
        });

    // You can also assimilate it using collect:
    Collection<Room> kingSizeRooms = rooms.stream().filter(room -> room.getName().equals("King")).collect(Collectors.toList());
    // Use map to extract what is needed from the object before the next (print) stage
    kingSizeRooms.stream().map(room -> room.getName()).forEach(System.out::println);
    // Better
    kingSizeRooms.stream().map(Room::getName).forEach(System.out::println);

    Collection<Room> lowCostRooms = rooms.stream().filter(room -> room.getRate() < 300.0).collect(Collectors.toList());

    double total = lowCostRooms.stream().mapToDouble(Room::getRate).sum();
    System.out.println(total);
  }
}
