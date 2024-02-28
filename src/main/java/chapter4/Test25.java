package chapter4;

import java.util.Scanner;

import static chapter4.ListNode.listNodeToString;
import static chapter4.ListNode.stringToListNode;

/**
 * @program: sword-to-offer-test
 * @description: 链表中数字相加，本题位于书中第 60 题
 * @author: Stone
 * @create: 2024-02-28 09:26
 **/
public class Test25 {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的第一个链表为：");
            String inputStr1 = scanner.nextLine();

            System.out.print("输入的第二个链表为：");
            String inputStr2 = scanner.nextLine();

            // 计算结果
            ListNode result = addTowNumbers(stringToListNode(inputStr1), stringToListNode(inputStr2));
            System.out.println("相加后的链表为： " + listNodeToString(result));

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static ListNode addTowNumbers(ListNode listNode1, ListNode listNode2) {
        // 反转
        ListNode cur1 = reverseList(listNode1).next;
        ListNode cur2 = reverseList(listNode2).next;

        // 计算相加之和
        // 是否进位
        boolean plus = false;

        // 返回的结果链表，初始化哨兵节点
        ListNode result = new ListNode(0);
        ListNode cur3 = result;
        while (cur1 != null || cur2 != null) {
            // 两者都不为空
            int sum = 0;
            if (cur1 != null && cur2 != null) {
                sum = cur1.val + cur2.val + (plus ? 1 : 0);
            }
            if (cur1 != null && cur2 == null) {
                sum = cur1.val + (plus ? 1 : 0);
            }
            if (cur1 == null) {
                sum = cur2.val + (plus ? 1 : 0);
            }
            plus = sum >= 10;
            cur3.next = new ListNode(sum % 10);
            cur3 = cur3.next;
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }
        if (plus) cur3.next = new ListNode(1);
        return reverseList(result);
    }

    private static ListNode reverseList(ListNode head) {

        // 只有哨兵节点时直接返回
        if (head.next == null) return head;

        ListNode cur1 = head.next;
        ListNode cur2 = cur1.next;

        cur1.next = null;
        while (cur2 != null) {
            ListNode tmp = cur2.next;
            cur2.next = cur1;
            cur1 = cur2;
            cur2 = tmp;
        }
        head.next = cur1;
        return head;
    }
}

