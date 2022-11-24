package com.leetcode.easy.linkedlist;

import com.leetcode.collections.ListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list

public class RemoveDuplicateSortedLinkedList {

    public ListNode deleteDuplicatesBetter(ListNode head) {
        ListNode currentNode = head;

        while(currentNode != null) {
            // if we are at end of list
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
