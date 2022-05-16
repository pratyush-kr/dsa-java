package algorithms;

import java.util.Stack;

public class InfixToPostfix {
    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        }
        return 0;
    }

    private static boolean isAlphabet(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            return true;
        return false;
    }

    public static String inToPost(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for (int i = 0; i < infix.length(); i++) {
            if (isAlphabet(infix.charAt(i)) == true) {
                postfix += infix.charAt(i);
            } else if (infix.charAt(i) == '(') {
                stack.push(infix.charAt(i));
            } else if (infix.charAt(i) == '^') {
                stack.push(infix.charAt(i));
            } else if (infix.charAt(i) == ')') {
                while (stack.peek() != '#' && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else {
                if (precedence(infix.charAt(i)) > precedence(stack.peek())) {
                    stack.push(infix.charAt(i));
                } else {
                    while (stack.peek() != '#' && precedence(infix.charAt(i)) <= precedence(stack.peek())) {
                        postfix += stack.pop();
                    }
                    stack.push(infix.charAt(i));
                }
            }
        }
        while (stack.peek() != '#') {
            postfix += stack.pop();
        }
        return postfix;
    }
}
