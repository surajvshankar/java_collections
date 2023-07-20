package com.surshank.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;


public class RoomService {
  protected Collection<Room> rooms;
  public RoomService() {
    // this.rooms = new ArrayList<>();
    this.rooms = new LinkedHashSet<>(); // IMPORTANT: make sure room overrides not just equals but "hashCode"
  }

  public Collection<Room> getInventory() {
    // return this.rooms;
    // Always return a copy, so that the Collection (by pointer) is not modified outside the class.
    return new ArrayList<>(this.rooms);
  }

  public void createRoom(String name, double rate) {
    this.rooms.add(new Room(name, rate));
  }

  public void createRooms(Room[] rooms) {
//    for(Room room: rooms) {
//      this.rooms.add(room);
//    }
    this.rooms.addAll(Arrays.asList(rooms));
  }

  public void removeRooms(Room room) {
    for (Room r : this.rooms) {
      System.out.format("%s %s:\n", r.getName(), room.getName());
      System.out.format("r == room: %b\n", r == room);
      System.out.format("r.equals(room): %b\n", r.equals(room));
    }
    //this.rooms.remove(room);
    this.rooms.removeIf(r -> r.equals(room));
  }

  public boolean hasRoom(Room room) {
    return this.rooms.contains(room);
  }

  public Room[] asArray() {
//    Room[] array = new Room[this.rooms.size()];
//    this.rooms.toArray(array);
//    return array;

    // Better
    return this.rooms.toArray(new Room[0]);
    // To maintain Order - switch HashSet to LinkedHashSet
  }

  public Collection<Room> getLessThan(double price) {
    Collection<Room> filtered = new ArrayList<>(this.rooms);
    filtered.removeIf(r -> r.getRate() > price);
    return filtered;
  }

  public void applyDiscount(final double discount) {
    this.rooms.forEach(room -> room.setRate(room.getRate() - (room.getRate() * discount)/100));
  }
}
