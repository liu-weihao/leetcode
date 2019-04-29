package com.dx.ss.leetcode.LinkedListIntersection;

public class LinkedListIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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


    public static void main(String[] args) {
        ListNode C1 = new ListNode(5);
        ListNode C2 = new ListNode(9);
        ListNode C3 = new ListNode(8);
        C2.next = C3;
        C1.next = C2;

        ListNode headA = new ListNode(4);
        ListNode A1 = new ListNode(7);
        A1.next = C1;
        headA.next = A1;

        ListNode headB = new ListNode(3);
        ListNode B1 = new ListNode(1);
//        B1.next = C1;
        headB.next = C1;

        LinkedListIntersection linkedListIntersection = new LinkedListIntersection();
        ListNode node = linkedListIntersection.getIntersectionNode(headA, headB);
        System.out.println(node.val);

    }
}
