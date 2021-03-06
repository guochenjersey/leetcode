package org.black.lotus.oo.design.parking.lot;

import org.black.lotus.marker.LintCode;

/**
 *
 * Design a parking lot.

 see CC150 OO Design for details.
 1) n levels, each level has m rows of spots and each row has k spots.So each level has m x k spots.
 2) The parking lot can park motorcycles, cars and buses
 3) The parking lot has motorcycle spots, compact spots, and large spots
 4) Each row, motorcycle spots id is in range[0,k/4)(0 is included, k/4 is not included), compact spots id is in range [k/4,k/4*3) and large spots id is in range [k/4*3,k).
 5) A motorcycle can park in any spot
 6) A car park in single compact spot or large spot
 7) A bus can park in five large spots that are consecutive and within same row. it can not park in small spots

 Have you met this question in a real interview?
 Yes
 Example
 level=1, num_rows=1, spots_per_row=11
 parkVehicle("Motorcycle_1") // return true
 parkVehicle("Car_1") // return true
 parkVehicle("Car_2") // return true
 parkVehicle("Car_3") // return true
 parkVehicle("Car_4") // return true
 parkVehicle("Car_5") // return true
 parkVehicle("Bus_1") // return false
 unParkVehicle("Car_5")
 parkVehicle("Bus_1") // return true
 *
 * */
public class ParkingLot {
}
