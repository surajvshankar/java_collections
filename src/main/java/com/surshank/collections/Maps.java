package com.surshank.collections;

import java.util.HashMap;
import java.util.Map;


public class Maps {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    Integer returned = map.put("a", 1);
    System.out.println(returned);
    returned = map.put("a", 2);
    System.out.println(returned);
    System.out.println();

    // Collection view
    // map.keySet().forEach(System.out::println);
    map.entrySet().forEach(System.out::println);
    map.entrySet().forEach(e -> System.out.format("%s %d %n", e.getKey(), e.getValue()));
    System.out.println();

    swapping();
  }

  public static void swapping() {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);

    // Swapping Values
    Integer temp = map.put("b", map.get("a"));
    map.put("a", temp);
    map.forEach((k,v) -> System.out.format("%s : %d\n", k, v));
    System.out.println();

    // Swapping elements
    Integer temp2 = map.put("b", map.remove("a"));
    map.putIfAbsent("a", temp2);
    map.forEach((k,v) -> System.out.format("%s : %d\n", k, v));
  }
}
