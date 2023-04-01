import linkedlist.common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 */
public class Problem0019 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        int c = 0;
        while (end.next != null && c < n) {
            end = end.next;
            c++;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }

        start.next = start.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);






        ListNode result = removeNthFromEnd(l1, 1);
        System.out.println(result);

    }
}
