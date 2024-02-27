package chapter4;

import java.time.temporal.ValueRange;

/**
 * @program: sword-to-offer-test
 * @description: 链表类
 * @author: Stone
 * @create: 2024-02-27 14:03
 **/
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode stringToListNode(String strList) {
        try {
            // 第一个节点是哨兵节点
            ListNode listNode = new ListNode(0);
            if (strList != null && !strList.trim().isEmpty()) {
                String[] split = strList.split(",");
                ListNode cur = listNode;
                for (String s : split) {
                    cur.next = new ListNode(Integer.parseInt(s.trim()));
                    cur = cur.next;
                }
            }
            return listNode;
        } catch (Exception e) {
            throw new RuntimeException("字符串格式不符合规则，数字间使用英文逗号隔开！");
        }
    }

    public static String listNodeToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = node;
        while (cur.next != null) {
            sb.append(cur.next.val).append(",");
            cur = cur.next;
        }
        return sb.length() > 0 ? sb.substring(0, sb.length()-1) : "";
    }

}

