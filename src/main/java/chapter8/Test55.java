package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-05-04 23:41
 */

import chapter7.Test42;
import chapter7.Test42.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 * */
public class Test55 {

    public static class BSTIterator {
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.cur = root;
            stack = new Stack<>();
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }
            cur = stack.pop();
            int result = cur.val;
            cur = cur.rightNode;
            return result;
        }
    }

    /**
     * 逆向迭代器
    * */
    public static class BSTIteratorReversed {
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIteratorReversed(TreeNode root) {
            this.cur = root;
            stack = new Stack<>();
        }

        public boolean hasPre() {
            return cur != null || !stack.isEmpty();
        }

        public int pre() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.rightNode;
            }
            cur = stack.pop();
            int result = cur.val;
            cur = cur.leftNode;
            return result;
        }
    }

}