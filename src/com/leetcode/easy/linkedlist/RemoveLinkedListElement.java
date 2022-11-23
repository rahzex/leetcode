package com.leetcode.easy.linkedlist;

// https://leetcode.com/problems/remove-linked-list-elements

import com.leetcode.collections.ListNode;

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = new ListNode(0, head);
        ListNode pointToStart = currentNode;

        while (currentNode.next != null) {
            if (currentNode.next.val == val)
                currentNode.next = currentNode.next.next;
            else
                currentNode = currentNode.next;
        }

        return pointToStart.next;
    }
}

// c -> 7 ->  7 ->  7 ->  7
