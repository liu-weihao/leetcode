package com.dx.ss.leetcode.removeduplicates;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *  int val;
 *  ListNode next;
 *  ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesElement {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode next = head.next;
        while (next != null) {
            map.put(next.val, next);
            next = next.next;
        }
        ListNode result = new ListNode(head.val);
        result.next = head.next;
        next = result.next;
        for (Integer val : map.keySet()) {
            next.val = val;
            next.next = map.get(val);
            next = next.next;
        }
        System.out.println(result);
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args){
        RemoveDuplicatesElement removeDuplicatesElement = new RemoveDuplicatesElement();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        removeDuplicatesElement.deleteDuplicates(head);
    }
}
