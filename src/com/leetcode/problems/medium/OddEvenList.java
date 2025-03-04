package com.leetcode.problems.medium;

import static com.util.LogUtil.newLine;

/**
 * @author neeraj on 10/10/19
 * Copyright (c) 2019, data-structures.
 * All rights reserved.
 */
public class OddEvenList {


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
        newLine();
    }

    public static void main(String[] args) {
        ListNode sample = new ListNode(1);
        sample.next = new ListNode(2);
        sample.next.next = new ListNode(3);
        sample.next.next.next = new ListNode(4);
        sample.next.next.next.next = new ListNode(5);

        printList(sample);

        sample = oddEvenList(sample);

        printList(sample);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode prev = head.next;
        ListNode fast = prev.next;
        ListNode nextOfSlow;

        while (fast != null) {
            nextOfSlow = slow.next;
            slow.next = fast;
            prev.next = fast.next;
            fast.next = nextOfSlow;
            slow = slow.next;
            prev = prev.next;

            if (prev == null) {
                break;
            }
            fast = prev.next;
        }
        return head;
    }
}
