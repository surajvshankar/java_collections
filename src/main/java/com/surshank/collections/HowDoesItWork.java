package com.surshank.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class HowDoesItWork {
  public static void main(String[] args){
    Collection<String> sample = new HashSet<>();
    sample.add("a");
    sample.add("b");
    sample.add("c");
    sample.add("d");
    sample.add("e");
    sample.add("f");

    Collection<String> retain = new HashSet<>();
    retain.add("c");
    retain.add("d");
    retain.add("z");

    Boolean rs = sample.retainAll(retain);
    System.out.println(sample);
    System.out.println(rs);

    // Cannot new Collection - interface
    //Collection<String> words = new Collection<>();
    // ArrayList - IMPORTANT: ImplementationInterface => Implementation == Array, Interface == List
    Collection<String> words = new ArrayList<>();

    // Better still:
    List<String> words2 = new ArrayList<>();
    //words2.add(1); // Required type: String Provided: int

    List words3 = new ArrayList<>(); // Default to Object
    words3.add(1); // Wrapper type Integer
    words3.add("hello");
    words3.forEach(e -> System.out.println(e.getClass()));

    // Identity
    Boolean check = words == words? true: false;
    // Value
    check = words.equals(words)? true: false;
  }
}
