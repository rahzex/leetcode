package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.collections.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!

public class IntersectionOfLinkedLists {

    // TC : O(m+n)
    // SC : O(1)
    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        // Intuition : both a and b covers same length after switching pointers thus reaching intersection at same time.

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    // TC : O(m+n)
    // SC : O(m+n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null || headB != null) {
            if (null != headA) {
                if (nodes.contains(headA))
                    return headA;
                else
                    nodes.add(headA);
                headA = headA.next;
            }

            if (null != headB) {
                if (nodes.contains(headB))
                    return headB;
                else
                    nodes.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}
