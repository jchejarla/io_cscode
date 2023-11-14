package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class SortColors {

    static int[] countOccurrencesAndAddThemToResult(int[] nums) {

        // first count 0's, 1's and 2's, below we are counting just zeros and ones,
        // any remaining are twos
        int zeros = 0;
        int ones = 0;

        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else if (num == 1) {
                ones++;
            }
        }

        // once we know how many 0's, 1's and 2's are there, place them back into the array.
        for (int i = 0; i < nums.length; i++) {
            if (i < zeros) {
                nums[i] = 0;
            } else if (i < zeros+ones) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

        return nums;
    }

    static int[] usingTwoPointers(int[] nums) {
        int left= 0;
        int right = nums.length -1;
        int current = 0;

        while(current<=right) {
            if(nums[current] == 0){
                int temp = nums[left];
                nums[left] = nums[current];
                nums[current] = temp;
                left++;
                current++;
            } else if (nums[current] ==1) {
                current++;
            } else {
                int temp = nums[right];
                nums[right] = nums[current];
                nums[current] = temp;
                right--;
            }
        }
        return nums;
    }



    public static void main(String[] args) {
        System.out.println("############### Count 0's, 1's and 2's and put them in order ######################");
        System.out.println(Arrays.toString(countOccurrencesAndAddThemToResult(new int[]{2,0,2,1,1,0})));
        System.out.println(Arrays.toString(countOccurrencesAndAddThemToResult(new int[]{2,0,1})));

        System.out.println("############### Using two pointers, move 0's to left and move 2's to right ######################");
        System.out.println(Arrays.toString(usingTwoPointers(new int[]{2,0,2,1,1,0})));
        System.out.println(Arrays.toString(usingTwoPointers(new int[]{2,0,1})));

    }
}
