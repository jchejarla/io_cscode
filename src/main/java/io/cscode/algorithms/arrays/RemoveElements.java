package io.cscode.algorithms.arrays;

public class RemoveElements {


    /* in-place removal of element using two pointers */
    static int inPlaceRemovalUsingTwoPointers(int[] nums, int val) {

        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(inPlaceRemovalUsingTwoPointers(new int[]{1 ,1, 2, 3}, 1));
        System.out.println(inPlaceRemovalUsingTwoPointers(new int[]{2, 3, 1, 1}, 1));
    }
}
