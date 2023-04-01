import linkedlist.common.ListNode;

/**
 * 2. 两数相加
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 * - 每个链表中的节点数在范围 [1, 100] 内
 * - 0 <= Node.val <= 9
 * - 题目数据保证列表表示的数字不含前导零
 *
 *
 */
public class Problem2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode tmp = start;
        while (p1 != null && p2 != null) {
            ListNode node = new ListNode(p1.val + p2.val);
            tmp.next = node;
            p1 = p1.next;
            p2 = p2.next;
            tmp = node;
        }

        if (p1 != null) {
            tmp.next = p1;
        } else if (p2 != null) {
            tmp.next = p2;
        }

        ListNode p = start;
        int addNum = 0;
        while (p.next != null) {
            int left = (p.next.val + addNum) % 10 ;
            addNum = (p.next.val + addNum) / 10;
            p.next.val = left;
            p = p.next;
        }
        if (addNum != 0) {
            ListNode last = new ListNode(addNum);
            p.next = last;
        }
        return start.next;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

//        ListNode l1 = new ListNode(0);
//
//        ListNode l2 = new ListNode(0);

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3);

    }



}
