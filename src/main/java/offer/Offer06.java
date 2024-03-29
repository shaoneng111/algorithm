package offer;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class Offer06 {

    static class ListNode {
        ListNode next;
        int val;
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            ++size;
            p = p.next;
        }
        int[] result = new int[size];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }


}
