package io.cscode.algorithms.slidingwindow;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); // O(n log n)
        int left = 0;
        int right=0;
        int maxFrequency = 0;
        long sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            /*
              window length * nums[right] --> this is the value if we make all of left side elements same as current element.
              sum +k --> cumulative sum, and we can distribute K among those numbers.
              if left side value is greater, then we won't be able to all of left side elements in current window to same as current element.
              So, we will shift the window.
            */
            while((long) (right - left + 1) * nums[right] > sum+k) {
                sum -= nums[left];
                left++;
            }
            maxFrequency = Math.max(maxFrequency, right-left+1);
            right++;
        }
        return maxFrequency;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1,1,1,2,2,4}, 3));
        System.out.println(maxFrequency(new int[]{1,4,8,13}, 5));
        System.out.println(maxFrequency(new int[]{1,2,4}, 5));
        System.out.println(maxFrequency(new int[]{3,9,6}, 2));

    }
}
