package org.black.lotus.lintcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InsertIntoACyclicSortedListTest {

  private InsertIntoACyclicSortedList insertIntoACyclicSortedList;

  @Before
  public void setup() {
    insertIntoACyclicSortedList = new InsertIntoACyclicSortedList();
  }

  @Test
  public void should_insert() {
    ListNode node = new ListNode(1);
    node.next = node;
    ListNode insertedNode = insertIntoACyclicSortedList.insert(node, 3);
    assertEquals(3, insertedNode.val);
  }

  @Test
  public void should_handle_null_node() {
    ListNode insertedNode = insertIntoACyclicSortedList.insert(null, 2);
    assertEquals(2, insertedNode.val);
    assertNotNull(insertedNode.next);
  }
}