package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.collections.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
// https://www.youtube.com/watch?v=354J83hX7RI

public class LinkedListCycle {

    // Simple Approach with HashSet and equals and hashcode implemented in ListNode
    // TC : O(n)
    // SC : O(n)
    public boolean hasCycleWithHashSet(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head))
                return true;
            nodes.add(head);
            head = head.next;
        }
        return false;
    }
    // Using Two Pointers / Slow and Fast / Walker & Runner Approach
    // Floyd's tortoise and hare Algorithm
    // TC : O(n)
    // SC : O(1)
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }
}
