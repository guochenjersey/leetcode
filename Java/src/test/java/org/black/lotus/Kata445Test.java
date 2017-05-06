package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenguo on 5/5/17.
 */
public class Kata445Test {

    @Test
    public void testKata445() {
        ListNode seven = new ListNode(7);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);

        seven.next = two;
        two.next = four;
        four.next = three;

        seven.println();

        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode si = new ListNode(4);

        five.next = six;
        six.next = si;

        five.println();

        Kata445 kata445 = new Kata445();
        kata445.addTwoNumbers(seven, five);
    }

    @Test
    public void testKata4452() {
        ListNode five = new ListNode(5);
        Kata445 kata445 = new Kata445();
        ListNode node = kata445.addTwoNumbers(five, five);
        node.println();
    }

    @Test
    public void testKata445199() {
        ListNode one = new ListNode(1);
        ListNode nine = new ListNode(9);
        ListNode nine2 = new ListNode(9);
        nine.next = nine2;
        Kata445 kata445 = new Kata445();
        ListNode node = kata445.addTwoNumbers(one, nine);
        node.println();
    }
}