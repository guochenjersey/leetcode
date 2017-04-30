package org.black.lotus.org.black.lotus.support;

import lombok.Data;

@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
