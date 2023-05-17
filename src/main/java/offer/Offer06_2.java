package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer06_2 {

    public static void main(String[] args) {

    }

    private final List<Integer> tmp = new ArrayList<>();

    static class ListNode {
        ListNode next;
        int val;
    }

    public int[] reversePrint(ListNode head) {
        recursive(head);
        int[] result = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i);
        }
        return result;

    }

    public void recursive(ListNode node) {
        if (node == null) {
            return;
        }
        recursive(node.next);
        tmp.add(node.val);
    }
}
