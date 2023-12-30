package io.cscode.algorithms.arrays;

import java.util.*;

public class ThreeSum {

    static List<List<Integer>> threeSum_Using_2Sum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> duplicates = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int twoSum = 0-num;
            int[] twoSumIndexes = TwoSum.twoSum(nums, twoSum);
            if(twoSumIndexes != null) {
                List<Integer> triplet = Arrays.asList(num, nums[twoSumIndexes[0]], nums[twoSumIndexes[1]]);
                triplet.sort(Comparator.naturalOrder()); // we can assume this is O(1) time as we are sorting just 3 numbers
                if(!duplicates.contains(triplet)) {
                    duplicates.add(triplet);
                    result.add(triplet);
                }
            }
        }
        return result;
    }

    static List<List<Integer>> threeSum_Using_Sorting_And_2Sum(int[] nums) {
        Arrays.sort(nums);// n (log n)
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++) {

            if(i==0 || nums[i] != nums[i-1]) { // since the array is sorted, we can ignore elements i and i-1 if they are same.
                                               // reason for that is, if there is a triplet found at i, the same triplet would have been found at i-1 as well
                int twoSum  = 0-nums[i];

                int low = i+1;
                int high = nums.length-1;

                while(low < high) {

                    if(nums[low] + nums[high] == twoSum) { // two sub problem answer is found, that gives us the triplet (i,low,high)
                        result.add(List.of(nums[i], nums[low], nums[high]));
                        //let's continue, as there could be other triplets with i as one element.
                        //while doing this lets avoid duplicates
                        low++;
                        while(low<high && nums[low] == nums[low-1]) {
                            low++;
                        }
                    } else if (nums[low]+nums[high] <twoSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum_Using_2Sum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum_Using_Sorting_And_2Sum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum_Using_Sorting_And_2Sum(new int[]{2,2,0,-2}));

    }
}
