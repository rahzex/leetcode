package com.leetcode.easy;

// https://leetcode.com/problems/min-stack

class MinStack {
    private Node head;

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            // current value is new head, previous head is on head.next
            head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * 8 4 2 1
 * ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
 * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
 *
 * O : [null,null,null,null,null,0,null,2,null,2,null,2]
 * E : [null,null,null,null,null,0,null,0,null,0,null,2]
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
