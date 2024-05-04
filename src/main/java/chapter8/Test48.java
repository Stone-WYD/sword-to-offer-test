package chapter8;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-26 15:13
 */

import chapter7.Test42;
import chapter7.Test42.TreeNode;

import java.util.Stack;

/**
 * 序列化和反序列化二叉树
 * */
public class Test48 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.leftNode = n1;
        n1.leftNode = n2;
        n2.leftNode = n3;
        n2.rightNode = n4;
        String serialize = serialize(root);
        System.out.println(serialize);

        TreeNode treeNode = deserialize(serialize);
        System.out.println(serialize(treeNode));

    }

    /*
    * 序列化时三种遍历方式没什么本质区别，但是在反序列化的时候，如果节点中的值都相等，
    * 则可能出现不同的树序列化出相同的字符串的情况，为了避免这种情况，可以将 null
    * 作为一种字符放入字符串中
    * */
    public static String serialize(TreeNode root) {
        if (root == null) return "#";
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                sb.append(cur.val).append(",");
                cur = cur.leftNode;
            }
            // 到叶子节点时，因为是先序遍历，所以这里给叶子节点左右两个空节点加入 #
            sb.append("#").append(",");
            cur = stack.pop();
            cur = cur.rightNode;
        }
        // 最后一个节点右边的空节点没机会 append，最后补上
        sb.append("#");
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] nodeInts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeInts[0]));
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        for (int i = 1; i < nodeInts.length; ) {
            while (!nodeInts[i].equals("#")) {
                stack.push(cur);
                cur.leftNode = new TreeNode(Integer.parseInt(nodeInts[i]));
                cur = cur.leftNode;
                i++;
            }
            // 遇到 # 时，说明要在左边加个空的叶子节点
            i++;
            i++;

            if (i >= nodeInts.length) break;
            while (nodeInts[i].equals("#")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                i++;
                if (i >= nodeInts.length) break;
            }
            if (i >= nodeInts.length) break;
            cur = stack.pop();
            cur.rightNode = new TreeNode(Integer.parseInt(nodeInts[i]));
            cur = cur.rightNode;
            i++;
        }
        return root;
    }

}