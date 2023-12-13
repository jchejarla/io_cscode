package io.cscode.algorithms.arrays;

public class NonDecreasingArray {

    static boolean checkPossibility(int[] nums) {
        boolean modified = false;

        for(int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {

                if (modified) {
                    return false;
                }

                if (i == 0 || nums[i + 1] >= nums[i - 1]) { // i==0 if there are only two elements in array
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
                modified = true;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,3}));
        System.out.println(checkPossibility(new int[]{-1,4,2,3}));
        System.out.println(checkPossibility(new int[]{4,2,1}));

    }
}
