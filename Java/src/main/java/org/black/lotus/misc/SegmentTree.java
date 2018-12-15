package org.black.lotus.misc;

public class SegmentTree {

    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start < end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }

        return root;
    }
}
