package com.surshank.collections;

import java.util.Comparator;


public class SortableRoom extends Room implements Comparable<SortableRoom> {
  public static Comparator<SortableRoom> RATE_COMPARATOR = Comparator.comparing(SortableRoom::getRate);
  public static Comparator<SortableRoom> CHAINED_COMPARATOR =
      Comparator.comparing(SortableRoom::getName).thenComparing(SortableRoom::getRate);

  public SortableRoom(String name, double rate) {
    super(name, rate);
  }

  // Extends Comparable Interface to place in Natural Order
  @Override
  public int compareTo(SortableRoom o) {
    int result = this.getName().compareTo(o.getName());
    System.out.format("Comparing %s with %s and got result: %d%n", this.getName(), o.getName(), result);
    return result;
  }
}
