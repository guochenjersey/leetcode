package org.black.lotus.org.black.lotus.support;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void println() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(String.format("\t %s", temp.val));
            temp = temp.next;
        }
        System.out.println();
    }
}
