package io.cscode.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] array, int target) {
        // base case to find a pair we need atleast two elements.
        if(array == null || array.length < 2) {
            throw new IllegalArgumentException("input array should contain atleast two elements");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++) {
            int current = array[i];
            int diff = target - current;
            Integer pairIndex = map.get(diff);
            if(pairIndex != null) { // we found other number index which adds up to target k
                return new int[] {pairIndex, i};
            } else {
                map.put(current, i); // store the number and its index
            }
        }
        return null; // none found
    }

}
