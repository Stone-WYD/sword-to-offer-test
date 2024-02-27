package chapter4;

import java.util.List;

/**
 * @program: sword-to-offer-test
 * @description: 两个链表的第1个重合节点，本题位于书中第 55 页
 * @author: Stone
 * @create: 2024-02-27 16:55
 **/
public class Test23 {

    public static void main(String[] args) {
        // 这里只是简单测试一下

        ListNode headA = new ListNode(1);
        ListNode curA = headA;
        curA.next = new ListNode(2);
        curA = curA.next;

        curA.next = new ListNode(3);
        curA = curA.next;

        ListNode headB = new ListNode(11);
        ListNode curB = headB;
        curB.next = new ListNode(12);
        curB = curB.next;

        curB.next = new ListNode(13);
        curB = curB.next;

        // new ListNode(5) 是应该返回的节点
        curA.next = curB.next = new ListNode(5);
        curA = curA.next;

        curA.next = new ListNode(6);
        curA = curA.next;

        curA.next = new ListNode(7);
        curA = curA.next;

        curA.next = new ListNode(8);
        curA = curA.next;

        ListNode resultNode = getIntersectionNode(headA, headB);
        System.out.println("结果为：" + resultNode.val);

    }

    // 该题的一种解法是将两条有重合部分的链表连起来形成带环的链表，然后就变成了 Test22.

    // 第二种解法利用栈来解决

    // 第三种解法利用两条链条长度来解决
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 默认 headA、headB 的第一个节点是哨兵节点
        int a = 0;
        int b = 0;

        ListNode cur = headA;
        while (cur.next != null) {
            a++;
            cur = cur.next;
        }
        cur = headB;
        while (cur.next != null) {
            b++;
            cur = cur.next;
        }

        return a > b ? doGetIntersectionNode(headA, a, headB, b) : doGetIntersectionNode(headB, b, headA, a);
    }

    public static ListNode doGetIntersectionNode(ListNode longList, int longLength, ListNode shortList, int shortLength) {
        // 起始节点获取
        ListNode longBeginNode = longList;
        ListNode shortBeginNode = shortList;

        int longBegin = longLength - shortLength;
        for (int i = 0; i < longBegin; i++) {
            longBeginNode = longBeginNode.next;
        }
        // 获取相同节点
        while (shortBeginNode != longBeginNode) {
            shortBeginNode = shortBeginNode.next;
            longBeginNode = longBeginNode.next;
        }
        return shortBeginNode;
    }

}

