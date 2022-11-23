package com.leetcode.easy;

import com.leetcode.collections.ListNode;

// https://leetcode.com/problems/middle-of-the-linked-list

public class MidOfLinkedList {

    /**
     * Intuition : if fast travels 2 times of slow then slow will be in mid when fast reaches the end.
     * Each time, slow goes 1 step while fast goes 2 steps.
     * When fast arrives at the end, slow will arrive right in the middle.
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
