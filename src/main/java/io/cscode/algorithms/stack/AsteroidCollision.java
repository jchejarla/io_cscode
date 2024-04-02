package io.cscode.algorithms.stack;


import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {


    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids) {
            boolean add = true;
            while(asteroid <0 && !stack.isEmpty() && stack.peek() >0) {
                if(Math.abs(asteroid) == stack.peek()) {
                    stack.pop();// remove the top, and don't add current since both are explode
                    add = false;
                    break;
                } else if(Math.abs(asteroid) < stack.peek()) {
                    add = false; // current is smaller, so it wil explode, so don't need to add
                    break;
                } else {
                    stack.pop();
                }
            }
            if(add) {
                stack.push(asteroid);
            }
        }
        int[] remaining = new int[stack.size()];
        for(int i=0;i<remaining.length; i++) {
            remaining[i] = stack.get(i);
        }
        return remaining;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-8, 8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));


    }

}
