package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {

    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> leaders = new ArrayList<>();
        // last index is always a leader as there is nothing in right of it.
        leaders.add(arr[arr.length - 1]);
        int lastLead = leaders.get(0);
        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] >= lastLead) {
                leaders.add(arr[i]);
                lastLead = arr[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
