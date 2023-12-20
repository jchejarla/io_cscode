package io.cscode.algorithms.strings;

import java.util.Stack;

public class BasicCalculatorII {

    static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char sign = '+'; // reason we are using this is say if the input is "10-2*3+5/2"
                         // assume + is default sign for 10, if the starting is -10 for example, then it will 0+ at the beginning.

        for(int i=0; i<s.length(); i++) {

            char current = s.charAt(i);

            if(Character.isDigit(current)) { // If the character is between 0-9
                number = number *10 + (current - '0'); // number *10 is to concatenate the number,
                                                        // say if the input is two digit letter,
                                                        // for example, 79 first we take 7, then when we get 9 we have to move 7 to 10th position,
                                                        // so we multiply with 10, then add current number.
            }

            if( (!Character.isDigit(current) && current != ' ')
                                        || i == s.length() -1 ) {

                if(sign == '+') {
                    stack.push(number);
                } else if(sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = current;
                number = 0;
            }

        }



        int result = 0;
        while(!stack.isEmpty()) {
            result+=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(calculate("3+5 / 2 "));
        System.out.println(calculate("10-2*3+5/2"));
        System.out.println(calculate("-10-2*3+5/2"));

    }
}
