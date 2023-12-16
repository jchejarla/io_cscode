package io.cscode.algorithms.arrays;

public class SignOfArray {

    static int arraySign(int[] nums) {
        int totalNegatives = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                return 0;
            }
            if(nums[i] <0) {
                totalNegatives++;
            }
        }

        return totalNegatives %2 ==0 ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
        System.out.println(arraySign(new int[]{1,5,0,2,-3}));
        System.out.println(arraySign(new int[]{-1,1,-1,1,-1}));
    }
}
