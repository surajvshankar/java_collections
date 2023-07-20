package com.surshank.collections;

import java.util.HashMap;
import java.util.Map;


public class BookingService {
  private Map<Room, Guest> bookings = new HashMap<>();

  public boolean book(Room room, Guest guest){
//    if (bookings.get(room) == null) {
//      bookings.put(room, guest);
//      return true;
//    }
//    return false;
    return bookings.putIfAbsent(room, guest) == null;
  }

  public double totalRevenue() {
//    double total = 0;
//    for ( Room room : bookings.keySet()) {
//      total = total + room.getRate();
//    };
//    return total;
    return bookings.keySet().stream().mapToDouble(Room::getRate).sum();
  }
}
