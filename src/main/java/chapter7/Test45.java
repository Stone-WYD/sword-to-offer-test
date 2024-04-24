package chapter7;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-24 16:34
 * */

import java.util.LinkedList;
import java.util.Queue;

import static chapter7.Test42.*;

/**
 * 二叉树最底层最左边的值
 * */
public class Test45 {

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        if (root != null) {
            queue1.offer(root);
        }
        int result = 0;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.leftNode != null) {
                queue2.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue2.offer(node.rightNode);
            }
            if (queue1.isEmpty()) {
                if (!queue2.isEmpty()) {
                    result = queue2.peek().val;
                    queue1 = queue2;
                    queue2 = new LinkedList<>();
                }
            }
        }
        return result;
    }

}