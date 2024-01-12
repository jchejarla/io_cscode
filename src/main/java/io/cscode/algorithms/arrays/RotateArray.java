package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class RotateArray {


    /**
     * Rotate array by K steps using a temporary array
     *
     * @param nums
     * @param k
     */
    static void rotateUsingTempArray(int[] nums, int k) {
        if(k ==0 ){
            return;
        }
        k %= nums.length; // If k is greater than array length, we just need to rotate mod number of times.
                          //Say if array is [1,2] and k=3, if we rotate 1st time-> [2,1], 2nd time -> [1,2]
                          // 3rd time -> [2,1], this is equivalent to rotate 1st time.
        int[] temp = new int[nums.length];
        int index=0;
        for(int i=nums.length-k; i<nums.length; i++) {
            temp[index++] = nums[i];
        }
        for(int i=0;i<nums.length-k;i++) {
            temp[index++] = nums[i];
        }
        for(int i=0;i< nums.length;i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * Rotate array by K steps using reverse and re-arrange elements approach
     * @param nums
     * @param k
     */
    static void rotateUsingReverseAndReArrangeApproach(int[] nums, int k) {
        if(k ==0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    static void reverse(int[] nums, int from, int to) {
        while(from<=to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        System.out.println("############### Using Temporary array approach ######################");
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotateUsingTempArray(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2};
        rotateUsingTempArray(nums, 3);
        System.out.println(Arrays.toString(nums));

        System.out.println("############### Reverse and rotate approach ######################");
        nums = new int[]{1,2,3,4,5,6,7};
        rotateUsingReverseAndReArrangeApproach(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2};
        rotateUsingReverseAndReArrangeApproach(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
