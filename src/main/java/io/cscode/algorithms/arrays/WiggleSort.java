package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class WiggleSort {

    static void wiggleSort(int[] nums) {

        if(nums.length == 1) {
            return;
        }
        int i=1;
        while(i <nums.length) {
            if(i%2 == 1&& nums[i] <nums[i-1]) {
                swap(nums, i, i-1);
            }
            if(i%2 == 0 && i+1 < nums.length && nums[i+1] > nums[i]) {
                swap(nums, i, i+1);
            }
            i++;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
