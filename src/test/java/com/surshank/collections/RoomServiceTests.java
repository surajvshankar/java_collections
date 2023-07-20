package com.surshank.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;


public class RoomServiceTests {
  RoomService service;

  Room presidential = new Room("Presidential", 500.00);
  Room king = new Room("King", 250.00);
  Room queen = new Room("Queen", 200.00);


  @BeforeEach
  public void setUp(TestInfo info) throws Exception {
    System.out.format("%nPerforming %s%n", info.getTestMethod().get().getName());

    this.service = new RoomService();
    this.service.createRoom("Presidential", 500.00);
    this.service.createRoom("King", 250.00);
    this.service.createRoom("Queen", 200.00);
  }

  @Test
  void testCreateRoom() {
    this.service.createRoom("Double", 100.00);

    assertEquals(4, this.service.getInventory().size());
  }

  @Test
  void testCreateRooms() {
    Room[] rooms = { this.presidential, this.king, this.queen };

    this.service.createRooms(rooms);

    int roomCount = 0;
    if (this.service.rooms instanceof ArrayList) {
      roomCount = 6;
    } else if (this.service.rooms instanceof HashSet) {
      roomCount = 3;
    }
    assertEquals(roomCount, this.service.getInventory().size());
  }

  @Test
  void testRemoveRooms() {
    this.service.removeRooms(new Room("King", 225.0));

    System.out.println(this.service.getInventory());
    assertEquals(2, this.service.getInventory().size());
    assertFalse(this.service.getInventory().contains(king));
  }

  @Test
  void testGetInventory() {
    assertNotNull(this.service.getInventory());
  }

  @Test
  void testHasRoom() {
    assertTrue(this.service.hasRoom(new Room("King", 225.0)));
    assertFalse(this.service.hasRoom(new Room("Double", 100.0)));
  }

  @Test
  void testAsArray() {
    Room[] rooms = this.service.asArray();

    assertEquals(3, rooms.length);
    assertEquals(this.presidential, rooms[0]);
    assertEquals(this.king, rooms[1]);
    assertEquals(this.queen, rooms[2]);
  }

  @Test
  void testGetLessThanPrice() {
    double cheaperThan = 250.0;
    Collection<Room> rooms = this.service.getLessThan(cheaperThan);

    assertEquals(2, rooms.size());
    assertTrue(rooms.stream().allMatch(r -> (r.getRate() <= cheaperThan)));
    assertEquals(3, this.service.getInventory().size());
  }

  @Test
  void testApplyDiscount() {
    double discount = 5.0;
    this.service.applyDiscount(discount);

    Map<String, Double> discountMap = new HashMap<>();
    discountMap.put("Presidential", 475.0);
    discountMap.put("King", 237.5);
    discountMap.put("Queen", 190.0);

    discountMap.forEach((k,v) ->
        assertEquals(this.service.rooms.stream().filter(r -> r.getName().equals(k)).findAny().get().getRate(), v));

//    List<Room> r1 = this.service.getInventory().stream().filter(room -> room.getName().equals("King")).collect(Collectors.toList());
//    assertEquals(237.5, r1.get(0).getRate());
  }
}
