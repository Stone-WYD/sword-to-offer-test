package chapter4;

import java.util.List;
import java.util.Scanner;

import static chapter4.ListNode.stringToListNode;
import static chapter4.Test24.reverseList;
import static chapter4.Test26.findMiddleListNodes;

/**
 * @program: sword-to-offer-test
 * @description: 回文链表，本题位于书中第 65 页
 * @author: Stone
 * @create: 2024-02-28 13:04
 **/
public class Test27 {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入的链表为：");
            String inputStr = scanner.nextLine();


            // 计算结果
            boolean result = isPalindrome(stringToListNode(inputStr));
            System.out.println("该链表是否为回文链表： " + result);

            System.out.print("输入“是”或“否”决定是否结束测试：");
            String e = scanner.next();
            if ("是".equals(e)) break;
        }
    }

    private static boolean isPalindrome(ListNode listNode) {
        List<ListNode> middle = findMiddleListNodes(listNode);
        ListNode curL = listNode.next;
        ListNode curR;
        if (middle.size() == 1) {
            reverseList(middle.get(0));
            curR = middle.get(0).next;
        } else {
            if (middle.get(0).val != middle.get(1).val) return false;
            reverseList(middle.get(1));
            curR = middle.get(1).next;
        }

        while (curR != null) {
            if (curL.val != curR.val) return false;
            curL = curL.next;
            curR = curR.next;
        }
        return true;
    }
}

