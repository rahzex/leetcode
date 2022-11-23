package com.leetcode.easy;

import com.leetcode.collections.ListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list

public class RemoveDuplicateSortedLinkedList {

    public ListNode deleteDuplicatesBetter(ListNode head) {
        ListNode currentNode = head;

        while(currentNode != null) {
            if (currentNode.next == null) {
                break;
            }
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
