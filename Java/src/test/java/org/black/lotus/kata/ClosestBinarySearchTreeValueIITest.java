package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.Queue;
import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class ClosestBinarySearchTreeValueIITest {

  @Test
  public void should_find_closest() {
    double target = 9.99999;
    Queue<TreeNode> results =
        new PriorityQueue<>(
            (o1, o2) -> {
              double diff1 = ((double) o1.val) - target;
              double diff2 = ((double) o2.val) - target;
              return (int) (Math.abs(diff1) - Math.abs(diff2));
            });

    TreeNode node1 = new TreeNode(11);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(12);

    results.offer(node1);
    results.offer(node2);
    results.offer(node3);

    while (!results.isEmpty()) {
      System.out.println(results.poll().val);
    }
  }
}
