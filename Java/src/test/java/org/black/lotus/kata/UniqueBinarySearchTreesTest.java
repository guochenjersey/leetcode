package org.black.lotus.kata;

import org.junit.Test;

public class UniqueBinarySearchTreesTest {

    @Test
    public void should_find_unique_binary_search_tree() {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int res = uniqueBinarySearchTrees.numTrees(18);
        System.out.println(res);
    }
}