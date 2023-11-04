package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Using prefix and postfix arrays
     */
    static int[] usingPrefixAndPostfixArrays(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            prefix[i] = nums[i] * (i ==0 ? 1 : prefix[i-1]);
        }
        for(int i=nums.length -1; i>=0; i--) {
            postfix[i] = nums[i] * (i==nums.length-1 ? 1 : postfix[i+1]);
        }

        int[] ans = new int[nums.length];
        for(int i=0 ;i< nums.length; i++) {
            ans[i] = (i==0 ? 1 : prefix[i-1]) * (i == nums.length-1 ? 1 : postfix[i+1]);
        }
        return ans;
    }

    /**
     *
     * we are going to use answer array itself to store prefix array values, then multiply those with postfix product
     */
    static int[] usingPrefixAndPostfixProductMemoryOptimized(int[] nums) {

        int[] ans = new int[nums.length];
       // building prefix product values and placing them at i+1,
       // as this is where we would need i.....k product at k+1 (th) index
        ans[0] = 1;
        for(int i=1; i<nums.length; i++) {
            ans[i] = nums[i-1] *ans[i-1];
        }

        // compute post fix and multiply that with ans[i]
        int postfix = 1;
        for(int i=nums.length -2; i>=0; i--){
            postfix = postfix * nums[i+1];
            ans[i] = ans[i] * postfix;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("############### Using prefix and postfix arrays ######################");
        System.out.println(Arrays.toString(usingPrefixAndPostfixArrays(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(usingPrefixAndPostfixArrays(new int[]{-1, 1, 0, -3, 3})));

        System.out.println("############### Using prefix and postfix arrays - memory optimized ######################");
        System.out.println(Arrays.toString(usingPrefixAndPostfixProductMemoryOptimized(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(usingPrefixAndPostfixProductMemoryOptimized(new int[]{-1, 1, 0, -3, 3})));

    }
}
