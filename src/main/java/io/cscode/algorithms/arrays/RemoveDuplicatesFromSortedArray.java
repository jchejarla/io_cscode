package io.cscode.algorithms.arrays;

public class RemoveDuplicatesFromSortedArray {

    static int removeDuplicates(int[] nums) {
        int dupIndex = 1;
        int prevElement = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != prevElement) {
                prevElement = nums[i];
                nums[dupIndex++] = nums[i];
            }
        }
        return dupIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }
}
