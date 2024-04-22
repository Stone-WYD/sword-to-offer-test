package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static chapter4.ListNode.listNodeToString;
import static chapter4.ListNode.stringToListNode;
import static chapter4.Test24.reverseList;

/**
 * @program: sword-to-offer-test
 * @description: 重排链表，本题位于书中第 63 页
 * @author: Stone
 * @create: 2024-02-28 10:34
 **/
public class Test26 {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的链表为：");
            String inputStr = scanner.nextLine();


            // 计算结果
            ListNode result = reorderList(stringToListNode(inputStr));
            System.out.println("重排后的链表为： " + listNodeToString(result));

            System.out.print("输入“是”或“否”决定是否结束测试：");
            String e = scanner.next();
            if ("是".equals(e)) break;
        }
    }

    private static ListNode reorderList(ListNode listNode) {
        // 默认有哨兵节点，起码要有一个节点才能排序
        if (listNode.next == null || listNode.next.next == null) return listNode;

        // 1. 找到中间节点（奇数有一个，偶数是两个节点）
        List<ListNode> middleListNodes = findMiddleListNodes(listNode);
        // 2. 左右两边根据题意进行重排
        ListNode cur = middleListNodes.size() == 1 ? middleListNodes.get(0) : middleListNodes.get(1);
        // 将右边的子序列进行重排
        reverseList(cur);
        ListNode curL = listNode.next;
        ListNode curR = cur.next;
        while (curR.next != null) {
           ListNode curLNext = curL.next;
           ListNode curRNext = curR.next;
           curL.next = curR;
           curL = curLNext;
           curR.next = curL;
           curR = curRNext;
        }
        curL.next = curR;
        curR.next = middleListNodes.get(0);
        cur.next = null;
        return listNode;
    }

    public static List<ListNode> findMiddleListNodes(ListNode listNode) {
        // 没有节点，则抛出异常
        if (listNode.next == null) {
            throw new RuntimeException("链表中没有节点，所以无法获取中间节点！");
        }
        List<ListNode> resultList = new ArrayList<>(2);
        ListNode fast, slow;
        fast = slow = listNode;
        // 奇数标识
        boolean isOdd = false;
        while (true) {
            // 走两步
            if (fast.next == null) {
                // 第一步是空，说明是偶数
                break;
            } else {
                // 走出第一步
                fast = fast.next;
                if (fast.next == null) {
                    // 第二步是空，说明是奇数
                    isOdd = true;
                    break;
                }
                // 走出第二步
                fast = fast.next;
            }
            // 走一步
            slow = slow.next;
        }
        // 放入中间节点
        if (isOdd) {
            resultList.add(slow.next);
        } else {
            resultList.add(slow);
            resultList.add(slow.next);
        }
        return resultList;
    }
}

