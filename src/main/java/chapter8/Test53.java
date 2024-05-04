package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-05-04 16:21
 */

import chapter7.Test42.TreeNode;

/**
* 二叉搜索树的下一个节点
* */
public class Test53 {

    // 方法1：中序遍历，cur == p 时，从栈中弹出的下一个节点即为结果，O(n)，n为节点数
    // 方法2：根据数值在二叉搜索树中查找，时间复杂度为 O(h)，h为树高
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null) {
            if (cur.val > p.val) {
                result = cur;
                cur = cur.leftNode;
            } else {
                cur = cur.rightNode;
            }
        }
        return result;
    }
}