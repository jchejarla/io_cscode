package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class ArrayWithElementsNotEqualToAverageOfNeighbors {


    static int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r = nums.length-1;

        int[] res = new int[nums.length];
        int index = 0;

        while(l<=r) {
            res[index++] = nums[l++];
            if(l<=r){ // to handle odd length arrays
                res[index++] = nums[r--];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(rearrangeArray(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
