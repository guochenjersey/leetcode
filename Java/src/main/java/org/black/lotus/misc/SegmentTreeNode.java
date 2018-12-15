package org.black.lotus.misc;

public class SegmentTreeNode {
    public int start, end;

    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
