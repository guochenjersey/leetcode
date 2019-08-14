package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PopulatingNextRightPointersInEachNodeTest {

    @Test
    public void should_populate_next_right_pointers() {
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode
                = new PopulatingNextRightPointersInEachNode();
        PopulatingNextRightPointersInEachNode.Node root = new PopulatingNextRightPointersInEachNode.Node(1);
        PopulatingNextRightPointersInEachNode.Node two = new PopulatingNextRightPointersInEachNode.Node(2);
        PopulatingNextRightPointersInEachNode.Node three = new PopulatingNextRightPointersInEachNode.Node(3);
        PopulatingNextRightPointersInEachNode.Node four = new PopulatingNextRightPointersInEachNode.Node(4);
        PopulatingNextRightPointersInEachNode.Node five = new PopulatingNextRightPointersInEachNode.Node(5);
        PopulatingNextRightPointersInEachNode.Node six = new PopulatingNextRightPointersInEachNode.Node(6);
        PopulatingNextRightPointersInEachNode.Node seven = new PopulatingNextRightPointersInEachNode.Node(7);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        populatingNextRightPointersInEachNode.connect(root);
        System.out.println(root);
    }
}