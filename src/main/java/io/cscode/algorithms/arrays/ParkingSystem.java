package io.cscode.algorithms.arrays;

public class ParkingSystem {

    private int[] parkingSlots = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        parkingSlots[0] = big;
        parkingSlots[1] = medium;
        parkingSlots[2] = small;
    }

    public boolean addCar(int carType) {
        if(parkingSlots[carType-1] >0) {
            parkingSlots[carType - 1] -= 1; // reduce count by 1 once the slot occupied
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));

    }
}
