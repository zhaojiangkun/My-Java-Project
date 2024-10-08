package com.JK.node;

import com.JK.util.ListNode;
import com.JK.util.ScanInUtil;

/**
 * 倒数第k个节点
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-08 21:58
 */
public class KthToLast {
    public static void main(String[] args) {
        ListNode node = ScanInUtil.scanInToListNode();
        int k = ScanInUtil.scanInToInt();
        System.out.println(kthToLast(node, k));

    }

    public static int kthToLast(ListNode head, int k) {
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        fast.next = head;
        slow.next = head;
        while(k > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next.val;
    }
}
