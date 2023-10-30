package io.cscode.algorithms.arrays;

public class FindPivotIndex {

    static int usingTwoPointers(int[] nums) {
        int total = 0;
        for(int i=0; i<nums.length; i++) {
            total += nums[i];
        }
        int leftSum = 0;
        for(int i=0;i <nums.length; i++) {
            int rightSum = total - nums[i] - leftSum;
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(usingTwoPointers(new int[]{-1, -1, -1, -1, -1, 0}));
        System.out.println(usingTwoPointers(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(usingTwoPointers(new int[]{1, 2, 3}));
        System.out.println(usingTwoPointers(new int[]{2,1,-1}));
        System.out.println(usingTwoPointers(new int[]{1,-1,2}));
    }
}
