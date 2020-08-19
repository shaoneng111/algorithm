/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package tree;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94.二叉树的中序遍历
 * 难度：中等
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author shaoneng
 * @date 2020/8/18 8:24 上午
 */
public class InOrderTraversal {

    // 下面提供递归和迭代两种方式
    public List<Integer> inorderTraversal(TreeNode root) {

        return null;
    }

    /**
     * 递归中序遍历
     *
     * 【通过】
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.9 MB, less than 56.05% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @return
     */
    public List<Integer> recursionInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursionHelper(root, res);
        return res;
    }

    public void recursionHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        recursionHelper(node.left, res);
        res.add(node.val);
        recursionHelper(node.right, res);
    }


    /**
     * 迭代中序遍历
     * 【通过】
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.3 MB, less than 98.22% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> iterationInorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ret.add(curr.val);
            curr = curr.right;
        }
        return ret;
    }


    public static void main(String[] args) {

        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.right = b;
        b.left = c;

        List<Integer> list = inOrderTraversal.recursionInorderTraversal(a);
        System.out.println(list);

        List<Integer> aList = inOrderTraversal.iterationInorderTraversal(a);
        System.out.println(aList);
    }
}
