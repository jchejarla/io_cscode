package io.cscode.algorithms.stack;

import java.util.Stack;

public class ValidateStackSequences {

    static boolean validateStackSequences(int[] pushed, int[] popped) {
       Stack<Integer> stackPushed = new Stack<>();
       int popIndex = 0;
       for(int pushElement: pushed) { // 2, 1, 0   --- 1, 2, 0 ==> true
           stackPushed.push(pushElement);
           while(!stackPushed.isEmpty() && popIndex<popped.length && stackPushed.peek() == popped[popIndex]) {
               stackPushed.pop();
               popIndex++;
           }
       }
       return stackPushed.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3}, new int[]{3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(validateStackSequences(new int[]{2,1,0}, new int[]{1,2,0}));

    }
}
