package chapter8;

import chapter7.Test42.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-24 20:48
 */
/**
 * 树的遍历
 * */
public class OrderTraversal {

    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 全部遍历一遍之后才推出 while 循环
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.rightNode;
        }
        return result;
    }

    // 前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.leftNode;
            }

            cur = stack.pop();
            cur = cur.rightNode;
        }
        return result;
    }

    // 后序遍历
    public static List<Integer> postorderTraveral(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }

            TreeNode peek = stack.peek();
            if (peek.rightNode != null && pre != peek.rightNode) {
                // 右边有节点而且还没去过，则先去右边，最后才遍历当前节点
                cur = peek.rightNode;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                pre = cur;
                cur = null;
            }
        }
        return result;
    }
}