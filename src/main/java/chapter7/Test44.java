package chapter7;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-24 16:10
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static chapter7.Test42.*;

/**
 * 二叉数中每层的最大值，如果要对二叉树分层，可以考虑使用两个队列
 * */
public class Test44 {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }

        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        while (!queue1.isEmpty()) {
            TreeNode poll = queue1.poll();
            max = Math.max(max, poll.val);
            if (poll.leftNode != null) {
                queue2.offer(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue2.offer(poll.rightNode);
            }
            if (queue1.isEmpty()) {
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }

        return result;
    }

}