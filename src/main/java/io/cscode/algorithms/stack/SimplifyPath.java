package io.cscode.algorithms.stack;

import java.util.Stack;

public class SimplifyPath {

    static String simplyPathUsingStringSplit(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for(String token: tokens) {
            if("..".equals(token)) {
                if(!stack.isEmpty()) stack.pop();
            } else if (!token.isEmpty() && !".".equals(token) && !"/".equals(token)) {
                stack.push(token);
            }
        }

        return "/"+String.join("/", stack);
    }

    static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String current = "";
        for(int i=0; i<=path.length(); i++) { // i<=path.length(), to handle what 'current' holds at the end loop
            if(i == path.length() || path.charAt(i) == '/') { //directory separator or end of path
                if("..".equals(current)) {
                    if(!stack.isEmpty()) stack.pop(); // is stack is not empty remove it , otherwise ignore it
                } else if (!current.isEmpty() && !".".equals(current)) {
                    stack.push(current);
                }
                current = "";
            } else {
                current += path.charAt(i);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../abc//./def"));
        System.out.println(simplyPathUsingStringSplit("/../abc//./def"));
        System.out.println(simplifyPath("/abc/def/ghi/../../.."));
        System.out.println(simplyPathUsingStringSplit("/abc/def/ghi/../../.."));

    }
}
