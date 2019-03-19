package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and set. get(key) - Get the value (will always be positive) of the key
 * if the key exists in the cache, otherwise return -1. set(key, value) - Set or insert the value if
 * the key is not already present. When the cache reached its capacity, it should invalidate the
 * least recently used item before inserting a new item.
 *
 * <p>TODO
 */
@Amazon
@LintCode
@FirstRound
@Medium
public class LRUCache {

  private int capacity;
  private DoubleLinkedNode head = new DoubleLinkedNode(-1, -1);
  private DoubleLinkedNode tail = new DoubleLinkedNode(-1, -1);
  private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.tail.prev = head;
    this.head.next = tail;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    DoubleLinkedNode current = cache.get(key);

    return -1;
  }

  public void set(int key, int value) {}
}

class DoubleLinkedNode {
  DoubleLinkedNode prev;
  DoubleLinkedNode next;
  int key;
  int value;

  DoubleLinkedNode(int key, int value) {
    this.key = key;
    this.value = value;
    prev = null;
    next = null;
  }
}
