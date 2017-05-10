package org.black.lotus.org.black.lotus.support;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return val == node.val &&
                Objects.equal(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val, next);
    }
}
