package com.JK.util;

import java.util.Scanner;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-07 13:02
 */
public class ScanInUtil {

    public static int[] scanInToIntArray(){
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] splitS = nextLine.split(",");
        int[] nums = new int[splitS.length];
        for (int i = 0; i < splitS.length; i++) {
            nums[i] = Integer.parseInt(splitS[i]);
        }
        return nums;
    }

    public static ListNode scanInToListNode(){
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] splitS = nextLine.split(",");
        ListNode node = new ListNode();
        ListNode res = node;
        for (String split : splitS) {
            node.next = new ListNode(Integer.parseInt(split));
            node = node.next;
        }
        return res.next;
    }

    public static int scanInToInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
