package com.leetcode.easy;

import java.util.Stack;

import com.leetcode.collections.ListNode;

// https://leetcode.com/problems/palindrome-linked-list
// https://www.youtube.com/watch?v=-DtNInqFUXs

public class PalindromeLinkedList {

    // T O(n), S O(1)
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        // find mid of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // special case for odd list, takes the next node after midd
        if (fast != null)
            slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    // reverses a linkedlist
    public ListNode reverse(ListNode node) {
        ListNode next;
        ListNode prev = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    // T O(n), S O(n)
    public boolean isPalindromeEasier(ListNode head) {
        ListNode handler = head;
        Stack<Integer> nodes = new Stack<>();

        while (handler != null) {
            nodes.push(handler.val);
            handler = handler.next;
        }

        while (head != null) {
            if (head.val != nodes.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}


//  1   2   3   1   2 -> null
//  1   2   3   1   2   3 -> null
