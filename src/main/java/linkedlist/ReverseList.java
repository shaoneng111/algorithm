/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package linkedlist;

import linkedlist.common.ListNode;

import java.lang.reflect.Parameter;
import java.util.List;

/**
 * 206.反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shaoneng
 * @date 2020/8/5 7:26 下午
 */
public class ReverseList {

    private ListNode head;
    private ListNode newHead;

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        this.head = head;
        recursionReverse(head, head);
        return newHead;
    }

    /**
     * 递归方法
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 39.5 MB, less than 21.47% of Java online submissions for Reverse Linked List.
     *
     * @param firstNode
     * @param nextNode
     */
    private void recursionReverse(ListNode firstNode, ListNode nextNode) {
        if (nextNode == null) {
            newHead = firstNode;
            return;
        }
        ListNode tmpNext = nextNode.next;
        nextNode.next = firstNode;
        head.next = tmpNext;
        recursionReverse(nextNode, tmpNext);
    }

    /**
     * 迭代方法
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 40.4 MB, less than 5.01% of Java online submissions for Reverse Linked List.
     *
     * @param head
     * @return
     */
    public ListNode iterationReverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;
        p.next = null;
        while (q != null) {
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }

        return p;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        ListNode head = reverseList.reverseList(node1);
        ListNode head = reverseList.iterationReverse(node1);
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
