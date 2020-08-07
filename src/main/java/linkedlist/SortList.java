/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package linkedlist;

import linkedlist.common.ListNode;

/**
 * 148.排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author shaoneng
 * @date 2020/8/6 5:42 下午
 */
public class SortList {

    /**
     * 【通过】
     *  Runtime: 602 ms, faster than 6.77% of Java online submissions for Sort List.
     *  Memory Usage: 42.8 MB, less than 11.12% of Java online submissions for Sort List.
     *
     * 链表头插法排序，时间复杂度为O(n2)，空间复杂度为O(1)
     * 不满足题意时间复杂度为O(n log n)的需求
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 设置哨兵结点
        ListNode sentinel = new ListNode(-1);
        sentinel.next = null;

        ListNode p = head;
        while (p != null) {
            ListNode target = p;
            p = p.next;
            target.next = null;
            if (sentinel.next == null) {
                sentinel.next = target;
            } else {
                ListNode q = sentinel;
                while (q.next != null && q.next.val < target.val) {
                    q = q.next;
                }
                target.next = q.next;
                q.next = target;
            }
        }
        return sentinel.next;
    }

    /**
     * 【参考答案】
     * @link https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
     * 归并排序【递归方法】，时间复杂度为O(n log n)，空间复杂度为O(log n)
     * 不满足题意空间复杂度为O(1)的需求
     *
     * @param head
     * @return
     */
    public ListNode recursionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    /**
     * 归并排序【非递归方法】，时间复杂度为O(n log n)，空间复杂度为O(1)
     * 满足题意需求
     *
     * @param head
     * @return
     */
    public ListNode unRecursionSortList(ListNode head) {

        return null;
    }

    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        ListNode head = s.recursionSortList(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
