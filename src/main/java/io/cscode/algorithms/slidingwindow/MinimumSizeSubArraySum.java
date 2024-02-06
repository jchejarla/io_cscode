package io.cscode.algorithms.slidingwindow;

public class MinimumSizeSubArraySum {

    static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum =0;
        int min = nums.length + 1;
        while(right < nums.length) {
            sum += nums[right];

            while(sum >=target) {
                min = Math.min(right - left +1 , min);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return min == nums.length +1 ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));

    }
}
