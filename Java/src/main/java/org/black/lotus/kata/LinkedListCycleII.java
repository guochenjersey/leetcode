package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Hard;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given a linked list, return the node where the cycle begins.
 *
 * <p>If there is no cycle, return null.
 *
 * <p>Have you met this question in a real interview? Example Given -21->10->4->5, tail connects to
 * node index 1，return 10 Explanation： The last node 5 points to the node whose index is 1, which is
 * 10, so the entrance of the ring is 10
 *
 * <p>Challenge Follow up:
 *
 * <p>Can you solve it without using extra space?
 *
 * <p>Related Problems
 *
 * <p>龟兔解法的基本思想可以用我们跑步的例子来解释，如果两个人同时出发，如果赛道有环，那么快的一方总能追上慢的一方。进一步想，追上时快的一方肯定比慢的一方多跑了几圈，即多跑的路的长度是圈的长度的倍数。
 *
 * <p>基于上面的想法，Floyd用两个指针，一个慢指针（龟）每次前进一步，快指针（兔）指针每次前进两步（两步或多步效果是等价的，只要一个比另一个快就行，从后面的讨论我们可以看出这一点。ps：考虑一个链表A有1000000个结点的环，链表B是有1000000个的非环的结点，然后再加一个只有3个结点的小环，如果兔子跑的更快点，即每次前进多于2步，那么能更快的检测链表A，但链表B就很慢，因为要一直绕圈等乌龟，所以选择2步是一个tradeoff）。如果两者在链表头以外的某一点相遇（即相等）了，那么说明链表有环，否则，如果（快指针）到达了链表的结尾，那么说明没环。
 *
 * <p>证明如下：
 *
 * <p>这样做的道理我用下图解释
 * 假设起点到环的起点距离为m，已经确定有环，环的周长为n，（第一次）相遇点距离环的起点的距离是k。那么当两者相遇时，慢指针移动的总距离为i，因为快指针移动速度为慢指针的两倍，那么快指针的移动距离为2i
 *
 * <p>1) i = m + p * n + k 2) 2i = m + q * n + ki
 *
 * <p>其中，p和q分别为慢指针和快指针在第一次相遇时转过的圈数。
 *
 * <p>2 ( m + p * n + k ) = m + q * n + k => 2m + 2pn + 2k = m + nq + k => m + k = ( q - 2p ) n
 *
 * <p>只要有一组p，q，k满足这个式子，假设就成立了。 我们假设
 *
 * <p>p = 0 q = m k = m n - m
 *
 * <p>那么我们证明如下
 *
 * <p>m + k = ( q - 2p ) n => m + mn - m = ( m - 2*0) n => mn = mn.
 *
 * <p>这时，i为
 *
 * <p>i = m + p n + k => m + 0 * n + mn - m = mn. 假设成立。
 *
 * <p>环的检测
 *
 * <p>环的检测是Floyd解法的第二部分。
 * 一旦乌龟和兔子相遇，将慢指针移到链表起点，快指针还在他们相遇的地方，即离环的起点距离k的地方。然后慢指针和快指针同时移动，每次移动一步，那么两者再次相遇的地方就是环的起点。
 *
 * <p>证明如下： 让乌龟和兔子都同时移动m+k步，乌龟到了他们最初遇见的地方（远离环起点k的位置） 之前我们得到 m + k = (q - 2p) n
 * 即兔子走了q-2p圈，也到了和乌龟同样的位置 现在我们不让乌龟走 m+k 步，让乌龟只走 m 步，兔子也后退k步，即到了环的起点，这是他们第一次相遇的地方。
 * 当他们相遇时，乌龟走的步数就是环的地点在的位置。
 *
 * <p>求环的长度的问题，第一次相遇后，再次相遇时，走的距离就是环的长度。 --------------------- 作者：Emily Du 来源：CSDN
 * 原文：https://blog.csdn.net/duxinyuhi/article/details/53379239 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@LintCode
@FirstRound
@Hard
@NoIdeaOrBadIdeaInitially
public class LinkedListCycleII {
  /**
   * @param head: The first node of linked list.
   * @return: The node where the cycle begins. if there is no cycle, return null
   */
  public ListNode detectCycle(ListNode head) {
    return null;
  }
}
