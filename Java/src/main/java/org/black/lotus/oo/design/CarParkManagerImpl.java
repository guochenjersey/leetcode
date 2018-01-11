package org.black.lotus.oo.design;

import com.google.common.collect.Lists;
import java.util.LinkedList;

public class CarParkManagerImpl implements CarParkManager {

  private LinkedList<ParkingLotPool> pool;


  @Override
  public void enter(Vehicle vehicle) {
    pool.stream()
        .filter(p -> p.isAvailable(vehicle))
        .findFirst()
        .ifPresent(p -> p.acquireLot(vehicle));
  }

  @Override
  public void exit(Vehicle vehicle) {
    pool.stream().filter(p -> p.isIn(vehicle)).findFirst().ifPresent(p -> p.returnLot(vehicle));
  }
}
