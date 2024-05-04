package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-26 20:07
 */

import chapter7.Test42.TreeNode;

/**
 * 从根节点到叶子节点的路径数字之和
 * */
public class Test49 {

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int path) {
        if (node == null) return 0;
        path = path * 10 + node.val;
        if (node.leftNode == null && node.rightNode == null) {
            return path;
        }
        return dfs(node.leftNode, path) + dfs(node.rightNode, path);
    }
}