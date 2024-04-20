package io.cscode.algorithms.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()[0] == c){
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }
            if(stack.peek()[1] == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(entry->sb.append(Character.toString(entry[0]).repeat(entry[1])));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 3));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
