package chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 链表中环的入口节点，本题位于书中第 52 页
 * @author: Stone
 * @create: 2024-02-27 14:51
 **/
public class Test22 {

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请按题意输入链表，假设不同val的节点为不同的节点，val相同时则形成环，否则无法达到测试目的。输入的链表为：");
            String inputStr = scanner.nextLine();

            // 计算结果
            // 测试没有环的情况
            // ListNode result = detectCycle(stringToListNode(inputStr));
            // 测试有环的情况
            ListNode result = detectCycle(getCycleList(inputStr));
            System.out.println("结果节点的val为: " + (result == null ? "空" : result.val));

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static ListNode getCycleList(String strList) {
        try {
            // 第一个节点是哨兵节点
            ListNode listNode = new ListNode(0);
            if (strList != null && !strList.trim().isEmpty()) {
                String[] split = strList.split(",");
                // 用于找到最后一个节点
                Map<Integer, ListNode> listNodeMap = new HashMap<>();
                ListNode cur = listNode;
                for (int i = 0; i < split.length; i++) {
                    if (i == split.length - 1) {
                        cur.next = listNodeMap.get(Integer.parseInt(split[i].trim()));
                        break;
                    }
                    int val = Integer.parseInt(split[i].trim());
                    cur.next = new ListNode(val);
                    listNodeMap.put(val, cur.next);
                    cur = cur.next;
                }
            }
            return listNode;
        } catch (Exception e) {
            throw new RuntimeException("字符串格式不符合规则，数字间使用英文逗号隔开！");
        }
    }

    public static ListNode detectCycle(ListNode head) {
        // 注：已默认第一个节点为哨兵节点
        ListNode p1, p2;
        p1 = p2 = head;

        int k = 0;

        while (true) {
            if (p2.next == null || p2.next.next == null) {
                // 不存在环，直接返回
                return null;
            }
            if (k != 0 && p1 == p2) break;
            // p2 移动速度是 p1 的两倍
            p1 = p1.next;
            p2 = p2.next.next;
            k++;
        }

        // 重置p2位置，p1、p2现在以相同速度前向运动
        p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

