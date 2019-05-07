package com.dx.ss.leetcode.PalindromeLinkedList;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode next = head.next;
        ListNode fast = next.next;
        slow.next = null;
        boolean odd = false;
        while (fast != null) {
            if (fast.next == null) odd = true;
            fast = (fast.next != null) ? fast.next.next : null;
            // reverse
            ListNode tmp = next.next;
            next.next = slow;
            slow = next;
            next = tmp;
        }
        if (odd) slow = slow.next;
        while (slow != null && next != null) {
            if (slow.val != next.val) return false;
            next = next.next;
            slow = slow.next;
        }
        return slow == next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
}
