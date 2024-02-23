package com.leetcode.easy.string;

import java.util.Stack;

public class BackspaceStringCompare {
    private static final Character HASH = '#';

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> charactersInStringOne = getStackOfValidCharactersFromString(s);
        Stack<Character> charactersInStringTwo = getStackOfValidCharactersFromString(t);
        boolean isStringSame = true;

        if (charactersInStringOne.size() == charactersInStringTwo.size()) {
            while (isNotEmpty(charactersInStringOne)) { // as the size is same, any one of the stack can be used here
                if (charactersInStringOne.pop() != charactersInStringTwo.pop()) { // check if currently popped element is not same
                    isStringSame = false;
                    break;
                }
            }
        } else {
            isStringSame = false;
        }

        return isStringSame;
    }

    private Stack<Character> getStackOfValidCharactersFromString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == HASH) {
                if (isNotEmpty(stack))
                    stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack;
    }

    private <T> boolean isNotEmpty(Stack<T> stack) {
        return !stack.isEmpty();
    }
}
