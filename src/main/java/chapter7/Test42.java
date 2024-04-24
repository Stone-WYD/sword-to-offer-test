package chapter7;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-24 15:35
 */

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test42 {

    /**
     * 最近请求次数
     * */
    public static class RecentAverage {

        private Queue<Integer> times;
        private int windosSize;

        public RecentAverage() {
            times =  new LinkedList<>();
            windosSize = 3000;
        }

        public int ping(int t) {
            times.offer(t);
            while (times.peek() + windosSize < t) {
                times.poll();
            }
            return times.size();
        }
    }

    /**
    * 广度优先遍历
    * */
    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.leftNode != null) {
                queue.offer(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.offer(poll.rightNode);
            }
        }
        return result;
    }

    public static class TreeNode {

        public TreeNode(int val, TreeNode leftNode, TreeNode rightNode) {
            this.val = val;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int val;

        public TreeNode leftNode;

        public TreeNode rightNode;
    }

}