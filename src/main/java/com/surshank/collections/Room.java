package com.surshank.collections;

public class Room {
  private String name;
  private double rate;

  public Room(String name, double rate) {
    this.name = name;
    this.rate = rate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public boolean equals(Object obj) {
    System.out.println("Performing an 'equals' comparison:");
    if (this == obj) {
      return true;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Room other = (Room) obj;
//    if (other == null) {
//      return false;
//    }
    if (this.getName() == null || other.getName() == null) {
      return false;
    }
    return this.getName().equals(other.getName());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getName() == null)? 0 : getName().hashCode());
    return result;
  }
}
