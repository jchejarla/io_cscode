package io.cscode.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        kSumRecursive(4, target, 0, nums, new ArrayList<>(), result);
        return result;
    }

    static void kSumRecursive(int k, long target, int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
        if(k == 2) { // reduced to two sum problem, this is the base case
            int left = start;
            int right = nums.length-1;
            while(left < right) {
                int currentSum = nums[left] + nums[right];
                if(currentSum == target) {
                    // Don't modify path, because we will continue checking other pairs
                    List<Integer> temp = new ArrayList<>(path);
                    temp.addAll(List.of(nums[left], nums[right]));
                    result.add(temp);
                    // for next loop, check if the next element is duplicate
                    left++;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if (currentSum < target ) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {

            for (int i = start; i < nums.length - k + 1; i++) { // +1 is because if there are only k elements
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<Integer> tempPath = new ArrayList<>(path); // add current element to the ones already in path.
                tempPath.add(nums[i]);
                kSumRecursive(k - 1, target - nums[i], i + 1, nums, tempPath, result);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));

    }
}
