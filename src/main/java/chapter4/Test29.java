package chapter4;

import java.util.Scanner;

/**
 * @program: sword-to-offer-test
 * @description: 排序的循环链表，本题位于书中第 69 页
 * @author: Stone
 * @create: 2024-02-29 14:25
 **/
public class Test29 {

    public static void main(String[] args) {
        ListNode head = null;

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("向链表中插入的值为：");
            int insertVal = scanner.nextInt();

            head = insert(head, insertVal);

            ListNode cur = head;
            System.out.print("链表当前节点为：");
            if (cur.next == head) {
                System.out.print(cur.val);
            } else {
                System.out.print(cur.val + " ");
                cur = cur.next;
                while (cur != head) {
                    System.out.print(cur.val + " ");
                    cur = cur.next;
                }
            }
            System.out.println();

            System.out.print("输入“是”或“否”决定是否继续插入值：");
            String e = scanner.next();
            if ("否".equals(e)) break;
        }




    }

    public static ListNode insert(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);
        // 循环链表中节点数小于 2 时要做特殊处理
        if (head == null) {
            node.next = node;
            head = node;
            return head;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        return insertCore(head, node);
    }

    private static ListNode insertCore(ListNode head, ListNode node) {
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode bigest = next;
        while (!(cur.val < node.val && node.val < next.val) && (next != head)) {
            if (bigest.val <= next.val) bigest = next;
            cur = next;
            next = next.next;
        }

        if (cur.val < node.val && node.val < next.val) {
            cur.next = node;
            node.next = next;
        } else {
            bigest.next = node;
            node.next = head;
        }

        return head;
    }
}

