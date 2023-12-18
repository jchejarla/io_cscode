package io.cscode.algorithms.arrays;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

public class UndergroundSystem {

    final HashMap<Integer, SimpleEntry<String, Integer>> checkInMap = new HashMap<>(); // Id -> (stationName, t)
    final HashMap<SimpleEntry<String, String>, int[]> totalTimeToCountMap = new HashMap<>(); //(startStation, endStation)
                                                                            // -> (totalTime, count)

    public UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new SimpleEntry(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        SimpleEntry<String, Integer> checkInTime = checkInMap.get(id);
        SimpleEntry<String, String> startEndStationsKey = new SimpleEntry<>(checkInTime.getKey(), stationName);
        int[] timesCount = new int[]{t - checkInTime.getValue(), 1};
        totalTimeToCountMap.merge(startEndStationsKey, timesCount, (oldVal, newVal) -> {
            oldVal[0]+= newVal[0];
            oldVal[1]+= newVal[1];
            return oldVal;
        });
    }

    public double getAverageTime(String startStation, String endStation) {
        SimpleEntry<String, String> key = new SimpleEntry<>(startStation, endStation);
        int[] countTimes = totalTimeToCountMap.get(key);
        return (double)countTimes[0]/countTimes[1];
    }

    public static void main(String[] args) {

        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }
}
