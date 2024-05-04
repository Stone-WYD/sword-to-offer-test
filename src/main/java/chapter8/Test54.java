package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-05-04 23:36
 */

import chapter7.Test42;
import chapter7.Test42.TreeNode;

import java.util.Stack;

/**
 * 所有大于或等于节点的值之和
 * */
public class Test54 {
    public static TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.rightNode;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.leftNode;
        }
        return root;
    }
}