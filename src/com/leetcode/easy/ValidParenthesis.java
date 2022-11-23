package com.leetcode.easy;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValidBetter(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            switch (c) {
                case '(': stack.push(')');
                    break;
                case '{': stack.push('}');
                    break;
                case '[': stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                        return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {

        if(null == s || "".equals(s))
            return false;

        char oppositeChar;
        Stack<Character> soc = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                soc.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {

                if (soc.empty())
                    return false;

                switch(s.charAt(i)) {

                    case ')' : oppositeChar = '(';
                        break;

                    case '}' : oppositeChar = '{';
                        break;

                    case ']' : oppositeChar = '[';
                        break;

                    default : return false;
                }

                if (oppositeChar == soc.peek())
                    soc.pop();
                else
                    return false;
            }
            else
                return false;

        }

        return soc.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]["));
    }
}
