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
}
