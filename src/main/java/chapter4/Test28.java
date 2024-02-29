package chapter4;

/**
 * @program: sword-to-offer-test
 * @description: 展平多级双向链表，本题位于书中第 67 页
 * @author: Stone
 * @create: 2024-02-29 09:56
 **/
public class Test28 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);


        n1.next = n2;
        n2.next = n3;
        n2.pre = n1;
        n3.pre = n2;
        n2.child = n4;
        n4.next = n5;
        n5.pre = n4;

        flatten(n1);
        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }

    public static void flatten(Node head) {
        flattenGetTail(head);
    }

    private static Node flattenGetTail(Node head) {
        if (head == null) return null;

        Node cur = head;

        while (cur != null) {
            // 1. 找到去下一级双向链表的节点，如果没有则不需要操作
            if (cur.child != null) {
                // 2. 获取下一级链表节点的展平链表
                Node child = flattenGetTail(cur.child);
                // 3. 将当前链表和下一级展平链表合并
                Node next = cur.next;
                cur.next = child;
                child.pre = cur;
                Node childCur = child;
                while (childCur.next != null) {
                    childCur = childCur.next;
                }
                // 4. childCur 指向最后一个节点
                childCur.next = next;
                next.pre = childCur;
                // 5. 指向下一个节点
                cur = next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}

