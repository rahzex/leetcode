package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.collections.ListNode;

public class ReverseLinkedList {

    /**
        In-place Reverse : https://www.youtube.com/watch?v=sYcOK51hl-A
        Time Complexity : O(n)
        Space Complexity : O(1)
     **/
    public ListNode reverseListBetter(ListNode head) {
        ListNode current = head;
        ListNode next;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        currentNode = head;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            currentNode.val = list.get(i);
            currentNode = currentNode.next;
        }

        return head;
    }
}
