package io.cscode.algorithms.arrays;

import java.util.HashMap;

public class MajorityElement {

    static int usingHashMapStoreCount(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxAppeared = 0;// to keep track of maximum number of times that a number appeared
        int max = 0; // to keep track of the number
        for(int num: nums) {
            int newVal = count.merge(num, 1, Integer::sum);
            if(newVal> maxAppeared) {
                maxAppeared = newVal;
                max = num;
            }
        }
        return max;
    }

    static int usingPatternSearch(int[] nums){
        int count = 0;
        int max =0;

        for(int num: nums) {
            if (count == 0) {
                max = num;
                count =1;
            } else if(num == max) {
                count++;
            } else {
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("############### Using Map to store count of each number ######################");
        System.out.println(usingHashMapStoreCount(new int[]{3,2,3}));
        System.out.println(usingHashMapStoreCount(new int[]{2,2,1,1,1,2,2}));
        System.out.println(usingHashMapStoreCount(new int[]{1}));
        System.out.println(usingHashMapStoreCount(new int[]{0}));

        System.out.println("############### Using Pattern-Search ######################");
        System.out.println(usingPatternSearch(new int[]{3,2,3}));
        System.out.println(usingPatternSearch(new int[]{2,2,1,1,1,2,2}));
        System.out.println(usingPatternSearch(new int[]{1}));
        System.out.println(usingPatternSearch(new int[]{0}));

    }
}
