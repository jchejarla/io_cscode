package io.cscode.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class FindAllMissingNumbersFromArray {

    /* Store array value in HashSet first, then loop through numbers 1....n and find missing numbers in HashSet*/
    static List<Integer> usingHashSetApproach(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        IntStream.of(nums).forEach(unique::add);

        List<Integer> missing = new ArrayList<>();
        for(int i=1; i<=nums.length; i++) {
            if(!unique.contains(i)) {
                missing.add(i);
            }
        }
        return missing;
    }

    /* loop through array, and mark indexed numbers 1....n will turn into indexes 0... n-1, then find missing ones*/
    static List<Integer> markIndexedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            nums[index] = -1 * Math.abs(nums[index]);
        }

        List<Integer> missing = new ArrayList<>();
        //after marking is done, loop through array and if value is +ve then that is a missing number.
        for(int i=0; i< nums.length; i++) {
            if(nums[i]>0) {
                missing.add(i+1);
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println("############### Store value in HashSet first and check missing numbers ######################");
        System.out.println(usingHashSetApproach(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(usingHashSetApproach(new int[]{1, 1}));

        System.out.println("############### Mark indexed numbers, then find missing ones ######################");
        System.out.println(markIndexedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(markIndexedNumbers(new int[]{1, 1}));

    }
}
