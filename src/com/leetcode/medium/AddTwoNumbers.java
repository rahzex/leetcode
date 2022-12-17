package com.leetcode.medium;

import com.leetcode.collections.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while(l1 != null) {
            num1.append(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            num2.append(l2.val);
            l2 = l2.next;
        }

        int sum = Integer.parseInt(num1.reverse().toString()) + Integer.parseInt(num2.reverse().toString());
        // 564
        ListNode result = new ListNode();
        ListNode head = result;

        int rem;
        while(sum != 0) {
            rem = sum % 10;
            sum = sum / 10;
            result.val = rem;
            if(sum != 0) {
                result.next = new ListNode();
                result = result.next;
            }
        }

        return head;
    }
}
