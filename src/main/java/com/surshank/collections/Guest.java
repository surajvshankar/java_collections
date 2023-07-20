package com.surshank.collections;

import java.util.ArrayList;
import java.util.List;


public class Guest {
  private String firstName;
  private String lastName;
  private boolean loyaltyProgramMember;
  private List<Room> preferredRooms= new ArrayList<>();

  public Guest(String firstName, String lastName, boolean loyaltyProgramMember) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.loyaltyProgramMember = loyaltyProgramMember;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isLoyaltyProgramMember() {
    return loyaltyProgramMember;
  }

  public void setLoyaltyProgramMember(boolean loyaltyProgramMember) {
    this.loyaltyProgramMember = loyaltyProgramMember;
  }

  public List<Room> getPreferredRooms() {
    return preferredRooms;
  }

  public void setPreferredRooms(List<Room> preferredRooms) {
    this.preferredRooms = preferredRooms;
  }

  @Override
  public String toString() {
    return "Guest{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", loyaltyProgramMember="
        + loyaltyProgramMember + ", preferredRooms=" + preferredRooms + '}';
  }
}
