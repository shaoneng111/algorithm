/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package tree;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-TreeNode-zigzag-level-order-traversal
 *
 * 【已通过】
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：2 ms, 在所有 Java 提交中击败了18.99%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了7.41%的用户
 *
 * @author shaoneng
 * @date 2020/7/10 4:51 下午
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        stack.add(root);
        int flag = 1;
        while (!stack.empty() || !queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!stack.isEmpty()) {
                node = stack.pop();
                queue.add(node);
            }
            while (!queue.isEmpty()) {
                node = queue.pollFirst();
                level.add(node.val);
                if (flag % 2 == 1) {
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                }
            }
            ret.add(level);
            flag++;
        }
        return ret;
    }

    public static void main(String[] args) {

        ZigzagLevelOrder zz = new ZigzagLevelOrder();

        TreeNode root = new TreeNode(1);
        TreeNode firstOne = new TreeNode(2);
        TreeNode firstTwo = new TreeNode(3);
        TreeNode secondOne = new TreeNode(4);
        TreeNode secondTwo = new TreeNode(5);
        TreeNode secondThree = new TreeNode(6);
        TreeNode secondFour = new TreeNode(7);
        TreeNode thirdOne = new TreeNode(8);
        TreeNode thirdTwo = new TreeNode(9);
        root.left = firstOne;
        root.right = firstTwo;
        firstOne.left = secondOne;
        firstOne.right = secondTwo;
        firstTwo.left = secondThree;
        firstTwo.right = secondFour;
        secondOne.left = thirdOne;
        secondOne.right = thirdTwo;
        List<List<Integer>> lists = zz.zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
