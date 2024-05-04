package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-26 21:16
 */

import chapter7.Test42;
import chapter7.Test42.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 向下的路径节点值之和
 * */
public class Test50 {

    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, map, sum);
    }

    public static int dfs(TreeNode root, int path, Map<Integer, Integer> map, Integer sum){
        if (root == null) {
            return 0;
        }
        path += root.val;
        int count = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);
        count += dfs(root.leftNode, path, map, sum);
        count += dfs(root.rightNode, path, map, sum);
        // 之前使 path 次数 +1 的操作只能影响子节点，递归到父节点之前应该删除，避免影响上级节点的计算
        map.put(path, map.get(path) - 1);

        return count;
    }

}