package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-05-04 23:55
 */

import chapter8.Test55.BSTIterator;
import chapter8.Test55.BSTIteratorReversed;

import static chapter7.Test42.*;

/**
 * 二叉搜索树中两个节点的值之和
 * */
public class Test56 {
    // 可以是用 Hash 法来解决，但是空间复杂度和时间复杂度都为 O(n)
    // 使用双指针法，用迭代器来实现，可以实现空间复杂度为 O(h)，时间复杂度为 O(n)
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator iterator = new BSTIterator(root);
        BSTIteratorReversed iteratorReversed = new BSTIteratorReversed(root);
        int point1 = iterator.next();
        int point2 = iteratorReversed.pre();
        while (point1 != point2) {
            if (point1 + point2 > k) {
                point2 = iteratorReversed.pre();
            } else if (point1 + point2 < k) {
                point1 = iterator.next();
            } else return true;
        }
        return false;
    }
}