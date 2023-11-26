package io.cscode.algorithms.strings;

import java.util.Stack;

public class MinSwapsToMakeStringBalanced {


    static int usingStack(String s) {
        Stack<Character> stack = new Stack<>();
        int swaps = 0;
        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) { // If the stack is empty, then a swap is needed
                    swaps++;
                } else {
                    stack.pop(); // Balance closing brackets with previous open bracket
                }
            }
        }
        return (swaps + 1)/2; // +1 to cover edge cases, where number of pairs to correct could be odd
                              // divide by 2 is because each swap operation will correct two unbalanced brackets
    }

    static int usingKeepingTrackOfClosingBrackets(String s) {
        int imbalanceCount = 0;
        int swaps = 0;

        for(char c: s.toCharArray()) {
            if(c == '[') {
                imbalanceCount++;
            } else {
                imbalanceCount--;
            }
            //If imbalanceCount is negative, make a swap to make it balance
            if(imbalanceCount <0){
                swaps++;
                // Now, reset the count to 0, to continue
                imbalanceCount =0;
            }
        }
        return (swaps +1) /2;
    }

    public static void main(String[] args) {
        System.out.println("############### Using a stack ######################");
        System.out.println(usingStack("][]["));
        System.out.println(usingStack("]]][[["));
        System.out.println(usingStack("]]]][[[["));
        System.out.println(usingStack("]]]]][[[[["));

        System.out.println("############### Keep track of closing brackets ######################");
        System.out.println(usingKeepingTrackOfClosingBrackets("][]["));
        System.out.println(usingKeepingTrackOfClosingBrackets("]]][[["));
        System.out.println(usingKeepingTrackOfClosingBrackets("]]]][[[["));
        System.out.println(usingKeepingTrackOfClosingBrackets("]]]]][[[[["));

    }
}
