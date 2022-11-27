package com.leetcode.easy;

import java.util.Stack;

public class BackSpaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c != '#')
                s1.push(c);
            else if(!s1.isEmpty())
                s1.pop();
        }

        for(char c : t.toCharArray()) {
            if(c != '#')
                s2.push(c);
            else if(!s1.isEmpty())
                s2.pop();
        }

        if(s1.size() != s2.size())
            return false;

        for(int i = 0; i < s1.size(); i++) {
            if(s1.pop() != s2.pop())
                return false;
        }
        return true;
    }


}
