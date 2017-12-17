package org.black.lotus.oo.design;

public interface ParkingLotPool {
  boolean isAvailable(Vehicle vehicle);

  boolean isIn(Vehicle vehicle);

  void acquireLot(Vehicle vehicle);

  void returnLot(Vehicle vehicle);
}
