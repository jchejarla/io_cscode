package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class MoveZeroes {

    static void moveZeroes(int[] nums) {

        int nonZeroIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // fill all remaining elements with 0's from where nonZeroIndex ended till end of array

        while(nonZeroIndex<nums.length){
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }

    public static void main(String[] args)  {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
