package chapter7;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-24 16:46
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static chapter7.Test42.*;

/**
 * 二叉树的右侧视图，二叉树从上向下看到的数组
 * */
public class Test55 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue1.offer(root);

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.leftNode != null) {
                queue2.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue2.offer(node.rightNode);
            }
            if (queue1.isEmpty()) {
                result.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }

        return result;
    }

}