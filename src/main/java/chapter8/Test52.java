package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-05-04 15:50
 */

import chapter7.Test42.TreeNode;

import java.util.Stack;

/**
 * 展平二叉搜索树
 * */
public class Test52 {

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode first = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }

            cur = stack.pop();
            if (pre != null) {
                pre.rightNode = cur;
            } else {
                first = cur;
            }

            cur.leftNode = null;
            pre = cur;
            cur = cur.rightNode;
        }

        return first;
    }



}