package com.majun.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3_head = null;
        ListNode l3_pre = new ListNode();
        ListNode l3_current;
        boolean over = false;
        while (l1 != null && l2 != null) {
            //sum and record over
            int sum = over ? l1.val + l2.val + 1 : l1.val + l2.val;
            over = sum >= 10;
            int l3_val = over ? sum - 10 : sum;

            //check head node

            //assign node
            l3_current = new ListNode(l3_val);
            if (l3_head == null) {
                l3_head = l3_current;
            } else {
                l3_pre.next = l3_current;
            }
            //next loop
            l1 = l1.next;
            l2 = l2.next;
            l3_pre = l3_current;
        }
        while (l1 != null) {
            //sum and record over
            int l1_val = over ? l1.val + 1 : l1.val;
            over = l1_val >= 10;
            int l3_val = over ? l1_val - 10 : l1_val;
            //assign node
            l3_current = new ListNode(l3_val);
            l3_pre.next = l3_current;
            //next loop
            l1 = l1.next;
            l3_pre = l3_current;
        }
        while (l2 != null) {
            //sum and record over
            int l2_val = over ? l2.val + 1 : l2.val;
            over = l2_val >= 10;
            int l3_val = over ? l2_val - 10 : l2_val;
            //assign node
            l3_current = new ListNode(l3_val);
            l3_pre.next = l3_current;
            //next loop
            l2 = l2.next;
            l3_pre = l3_current;
        }
        //at last, if over is true we need to new a node with val 1
        if (over) {
            l3_current = new ListNode(1);
            l3_pre.next = l3_current;
        }
        return l3_head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(8);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(7);
        ListNode b3 = new ListNode(8);
        b1.next = b2;
        b2.next = b3;

        ListNode listNode = new AddTwoNumbers().addTwoNumbers(a1, b1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



