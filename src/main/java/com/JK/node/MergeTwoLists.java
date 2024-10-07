package com.JK.node;

import com.JK.util.ListNode;
import com.JK.util.ScanInUtil;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-07 14:12
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = ScanInUtil.scanInToListNode();
        ListNode list2 = ScanInUtil.scanInToListNode();

        ListNode resNode = mergeTwoLists(list1, list2);
        while (resNode != null){
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2){
//        if(null == list1) return list2;
//        if(null == list2) return list1;
        ListNode head = new ListNode();
        ListNode  res = head;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        if(list2 == null) head.next = list1;
        if(list1 == null) head.next = list2;

        return res.next;
    }
}
