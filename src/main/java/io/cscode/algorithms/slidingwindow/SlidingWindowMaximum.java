package io.cscode.algorithms.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>(nums.length);
        int left =0;
        int right =0;

        int[] ans = new int[nums.length - k+1];
        int ai =0;

        while (right <nums.length) {
            while(!q.isEmpty() && q.peekLast() < nums[right]){
                q.pollLast();
            }
            q.offerLast(nums[right]);
            if(k<=right-left+1) {
                ans[ai++] = q.peekFirst();
                if(q.peekFirst() == nums[left++]) {
                    q.pollFirst();
                }
            }
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
