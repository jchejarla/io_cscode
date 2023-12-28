package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int dupIndex = 1;
        int prevElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prevElement && count<2) {
                nums[dupIndex++] = nums[i];
                count++;
            } else if (nums[i] != prevElement) {
                prevElement = nums[i];
                nums[dupIndex++] = nums[i];
                count =1;
            }
        }
        return dupIndex;
    }

    static int removeDuplicates_Simplified(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int dupIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[dupIndex -2]) {
                nums[dupIndex++] = nums[i];
            }
        }
        return dupIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println("Nums after : " + Arrays.toString(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println("Nums after : " + Arrays.toString(nums));
        nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println("Nums after : " + Arrays.toString(nums));

        System.out.println("########### Remove duplicates logic simplified ############");
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates_Simplified(nums));
        System.out.println("Nums after : " + Arrays.toString(nums));
        nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates_Simplified(nums));
        System.out.println("Nums after : " + Arrays.toString(nums));

    }
}
