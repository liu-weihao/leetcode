package com.dx.ss.leetcode.RemoveLinkedListElements;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return header.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
