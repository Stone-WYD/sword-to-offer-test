package chapter4;

import java.util.Scanner;

import static chapter4.ListNode.listNodeToString;
import static chapter4.ListNode.stringToListNode;

/**
 * 反转链表，本题位于书中第59页
 */
public class Test24 {

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的链表为：");
            String inputStr = scanner.nextLine();

            // 计算结果
            ListNode result = reverseList(stringToListNode(inputStr));
            System.out.println("反转后的链表为： " + listNodeToString(result));

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    /*private static ListNode reverseList(ListNode head) {
        // 默认有哨兵节点，如果链表没有节点或者只有一个节点
        if (head.next == null || head.next.next == null) return head;
        // 如果有两个个节点，则交换位置
        if (head.next.next.next == null) {
            ListNode tail = head.next;
            ListNode first = tail.next;
            head.next = first;
            first.next = tail;
            tail.next = null;
            return head;
        }

        // 默认是有哨兵节点的，需要三个节点跟着移动
        ListNode p1 = head.next;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        // 指向第一个节点的箭头指向 null
        p1.next = null;
        while (p3 != null) {
            // 调转 p1 -> p2 的箭头
            p2.next = p1;
            // 状态转移，p1,p2,p3向前移动一位
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        head.next = p2;
        return head;
    }*/

    public static ListNode reverseList(ListNode head) {

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
