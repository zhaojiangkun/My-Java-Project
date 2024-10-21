package com.JK.hot100;

import com.JK.util.ScanInUtil;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-21 13:34
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = ScanInUtil.scanInToIntArray();
        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height){
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            if(height[i] < height[j]){
                res = Math.max(res, height[i] * (j - i));
                i++;
            } else {
                res = Math.max(res, height[j] * (j - i));
                j--;
            }
        }
        return res;
    }
}
