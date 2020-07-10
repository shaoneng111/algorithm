/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package tree;

import tree.common.TreeNode;

/**
 * 98.验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * 【已通过】
 * @author shaoneng
 * @date 2020/7/10 2:14 下午
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return bfs(root, root.left, -1) && bfs(root, root.right, 1) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean bfs(TreeNode root, TreeNode node, int flag) {
        if (root == null || node == null) {
            return true;
        }
        if (flag < 0) {
            return root.val > node.val && bfs(root, node.left, -1) && bfs(root, node.right, -1);
        } else {
            return root.val < node.val && bfs(root, node.left, 1) && bfs(root, node.right, 1);
        }
    }


}
