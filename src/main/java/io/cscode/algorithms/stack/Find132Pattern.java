package io.cscode.algorithms.stack;

import java.util.Stack;

public class Find132Pattern {

    static boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int currentMin = nums[0];
        for(int i =1; i<nums.length; i++) {
            int current = nums[i];
            while(!stack.isEmpty() && current>=stack.peek()[0]) {
                stack.pop();
            }
            if(!stack.isEmpty() && current <stack.peek()[0] && current > stack.peek()[1]) {
                return true;
            }
            stack.push(new int[]{current, currentMin});
            currentMin = Math.min(current, currentMin);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3,1,4,2}));
        System.out.println(find132pattern(new int[]{1,2,3,4}));
    }
}
