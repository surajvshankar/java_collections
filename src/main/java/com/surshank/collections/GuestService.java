package com.surshank.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GuestService {
  private List<Guest> checkinList = new ArrayList<>();

  public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
    // Guests who have indicated the provided room as the "first" preferred
//    List<Guest> guestLikingThisRoom = new ArrayList<>();
//    for(Guest guest : guests) {
//      if(!guest.getPreferredRooms().isEmpty() && guest.getPreferredRooms().get(0).equals(room)) {
//        guestLikingThisRoom.add(guest);
//      }
//    }
//    return guestLikingThisRoom;

    return guests.stream().filter(guest -> guest.getPreferredRooms().indexOf(room) == 0).collect(Collectors.toList());
  }

  public void checkIn(Guest guest) {
    // Loyalty program need to be first in checkInList.
    if(guest.isLoyaltyProgramMember()) {
//      int highestLoyaltyIdx = -1;
//      for (int i = 0; i < this.checkinList.size(); i++ ) {
//        highestLoyaltyIdx = this.checkinList.get(i).isLoyaltyProgramMember()? i : highestLoyaltyIdx;
//      }
//      this.checkinList.add(highestLoyaltyIdx + 1, guest);
      int i = 0;
      for (; i < this.checkinList.size(); i++ ) {
        if(this.checkinList.get(i).isLoyaltyProgramMember()) {
          continue;
        }
        break;
      }
      this.checkinList.add(i, guest);
    } else {
      this.checkinList.add(guest);
    }
  }

  public void swapPosition(Guest guest1, Guest guest2) {
//    int idx1 = -1, idx2 = -1;
//    for (int i = 0; i < this.checkinList.size(); i++ ) {
//      if (this.checkinList.get(i).equals(guest1)) {
//        idx1 = i;
//      } else if (this.checkinList.get(i).equals(guest2)) {
//        idx2 = i;
//      }
//    }
    int idx1 = checkinList.indexOf(guest1);
    int idx2 = checkinList.indexOf(guest2);
    if (idx1 < 0) {
      System.out.println("Guest1 not found in the checkedin List");
      return;
    }
    if (idx2 < 0) {
      System.out.println("Guest2 not found in the checkedin List");
      return;
    }
    this.checkinList.set(idx1, guest2);
    this.checkinList.set(idx2, guest1);
  }

  public List<Guest> getCheckInList() {
    return new ArrayList<>(this.checkinList);
  }
}
