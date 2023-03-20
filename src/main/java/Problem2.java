


public class Problem2 {
     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
