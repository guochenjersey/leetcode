package org.black.lotus.kata;

import org.black.lotus.marker.*;

@FirstRound
@Easy
@LintCode
@Yelp
@Accepted
@Important
public class ReverseLinkedList {

  public ListNode reverseList(ListNode pHead) {
    ListNode pReversedHead = null; // 反转过后的单链表存储头结点
    ListNode pNode = pHead; // 定义pNode指向pHead;
    ListNode pPrev = null; // 定义存储前一个结点
    while (pNode != null) {
      ListNode pNext = pNode.next; // 定义pNext指向pNode的下一个结点
      if (pNext == null) { // 如果pNode的下一个结点为空，则pNode即为结果
        pReversedHead = pNode;
      }
      pNode.next = pPrev; // 修改pNode的指针域指向pPrev
      pPrev = pNode; // 将pNode结点复制给pPrev
      pNode = pNext; // 将pNode的下一个结点复制给pNode
    }
    return pReversedHead;
  }
}
