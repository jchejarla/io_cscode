package io.cscode.algorithms.arrays;

public class ValidPartition {

    public static boolean validPartition(int[] nums) {

        int n= nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for( int i=0; i<n; i++) {
            int dp_pos = i+1;

            if(i>0 && nums[i] == nums[i-1]) {
                dp[dp_pos] = dp[dp_pos] || dp[dp_pos-2];
            }
            if(i>1 && nums[i] == nums[i-1] && nums[i] == nums[i-2]){
                dp[dp_pos] = dp[dp_pos] || dp[dp_pos-3];
            }
            if(i>1 && nums[i] == nums[i-1]+1 && nums[i-1] == nums[i-2]+1) {
                dp[dp_pos] = dp[dp_pos] || dp[dp_pos-3];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        //System.out.println(false | false);
        System.out.println(validPartition(new int[] {1}));
    }
}
