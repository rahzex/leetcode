package com.leetcode.easy;

import com.leetcode.collections.ListNode;

public class MergeTwoLists {

    // [1,2,5,7]
    // [1,3,4,5,6,6,7,8,9]
    // [1,1,2,3,4,5,5,7,8,9]

    // 1,1,2,3,4,5,5,6,6,7,7

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        return head.next;
    }

    public static void printList(ListNode node) {
        while (null != node) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        mergeTwoSortedLists(new ListNode(), new ListNode(1));
    }

}
