package io.cscode.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicates {

    /* brute force approach */
    static boolean bruteForceApproach(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            for(int j= i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* using sorting approach */
    static boolean usingSortingApproach(int[] nums) {
        Arrays.sort(nums); // O(n log n)
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    /* Using hashset, store values into set and check if duplicate exists before putting a number into it */
    static boolean usingHashSet(int[] nums) {
        HashSet<Integer> cache = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(cache.contains(nums[i])) {
                return true;
            }
            cache.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("############### Brute force approach######################");
        System.out.println(bruteForceApproach(new int[] {1, 2, 3, 1}));
        System.out.println(bruteForceApproach(new int[] {1, 2, 3, 4}));

        System.out.println("############### Using sorting approach######################");
        System.out.println(usingSortingApproach(new int[] {1, 2, 3, 1}));
        System.out.println(usingSortingApproach(new int[] {1, 2, 3, 4}));

        System.out.println("############### Using HashSet efficient approach######################");
        System.out.println(usingHashSet(new int[] {1, 2, 3, 1}));
        System.out.println(usingHashSet(new int[] {1, 2, 3, 4}));

    }
}
