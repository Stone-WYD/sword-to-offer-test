package chapter4;

import java.util.Scanner;

import static chapter4.ListNode.listNodeToString;
import static chapter4.ListNode.stringToListNode;

/**
 * @program: sword-to-offer-test
 * @description: 删除倒数第 k 个节点，本题位于书中第 50 页
 * @author: Stone
 * @create: 2024-02-27 13:59
 **/
public class Test21 {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的链表为：");
            String inputStr = scanner.nextLine();
            System.out.print("删除链表的倒数位数为：");
            Integer k = scanner.nextInt();

            // 计算结果
            ListNode result = removeKthFromEnd(stringToListNode(inputStr), k);
            System.out.println("结果为: " + listNodeToString(result));

            System.out.print("此时输入 'exit' 可结束程序：");
            String e = scanner.next();
            if ("exit".equals(e)) break;
        }
    }

    private static ListNode removeKthFromEnd(ListNode listNode, Integer k) {
        ListNode cur1, cur2, cur2Last;
        cur1 = cur2 = cur2Last = listNode;
        int i = 0;
        while (cur1 != null) {
            cur1 = cur1.next;
            if (i < k) {
                // 向后移动
                i++;
            } else {
                // 当前位置开始 cur2 要开始移动
                cur2Last = cur2;
                cur2 = cur2.next;
            }
        }
        // 删除 cur2 指向的节点
        cur2Last.next = cur2.next;
        return listNode;
    }

}

