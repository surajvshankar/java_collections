package com.surshank.collections;

public class ValueBasedCar extends Car{
  public ValueBasedCar(String make, String model, int mileage) {
    super(make, model, mileage);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getMake() == null)? 0 : getMake().hashCode());
    result = prime * result + ((getModel() == null)? 0 : getModel().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    Car c = (Car) obj;
    System.out.format("Comparing %s %s with %s %s %n", this.getMake(), this.getModel(), c.getMake(), c.getModel());

    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Car other = (Car) obj;
    if (getMake() == null) {
      if (other.getMake() != null)
        return false;
    } else if (!getMake().equals(other.getMake()))
      return false;
    if (getModel() == null) {
      if (other.getModel() != null)
        return false;
    } else if (!getModel().equals(other.getModel()))
      return false;
    return true;
  }
}
