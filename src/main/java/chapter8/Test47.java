package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-26 14:43
 */

import chapter7.Test42;
import chapter7.Test42.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉树的剪枝
* */
public class Test47 {

    // 使用后序遍历，如果没有叶子节点且当前节点 val 为 0，则减除当前节点
    public TreeNode pruneTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        Set<TreeNode> removeSet = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }

            TreeNode peek = stack.peek();
            if (peek.rightNode != null && pre != peek) {
                cur = peek.rightNode;
            } else {
                cur = stack.pop();
                if (cur.leftNode != null && removeSet.contains(cur.leftNode)) {
                    removeSet.remove(cur.leftNode);
                    cur.leftNode = null;
                }
                if (cur.rightNode != null && removeSet.contains(cur.rightNode)) {
                    removeSet.remove(cur.rightNode);
                    cur.rightNode = null;
                }
                if (cur.leftNode == null && cur.rightNode == null && cur.val == 0) {
                    // 当前节点需要被删除，加入到删除队列中
                    removeSet.add(cur);
                }
                pre = cur;
                cur = null;
            }
        }
        return root;
    }

}