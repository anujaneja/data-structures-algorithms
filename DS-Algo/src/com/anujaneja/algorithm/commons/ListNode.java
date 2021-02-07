package com.anujaneja.algorithm.commons;


public class ListNode {
    public int      val;
    public ListNode next;

    public ListNode() {
        this.next = new ListNode();
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public String printLinkedList() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;

        while(curr!=null) {
            sb.append(curr.val+",");
            curr=curr.next;
        }

        return sb.toString();
    }
}
