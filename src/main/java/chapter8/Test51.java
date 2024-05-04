package chapter8;

import chapter7.Test42;

import static chapter7.Test42.*;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-05-04 15:13
 */
public class Test51 {
    // 节点值之和的最大路径
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    private static int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int[] maxLeftSum = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.leftNode, maxSum)) ;

        int[] maxRightSum = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.rightNode, maxRightSum));

        maxSum[0] = Math.max(maxLeftSum[0], maxRightSum[0]);
        maxSum[0] = Math.max(maxSum[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}