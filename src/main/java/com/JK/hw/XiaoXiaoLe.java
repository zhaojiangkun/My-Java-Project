package com.JK.hw;

import java.util.Scanner;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-30 11:38
 */
public class XiaoXiaoLe {

    private static int n, m;
    private static int[][] matrix;
    private static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = minClicksToZero();
        System.out.println(res);
    }

    private static int minClicksToZero() {
        int totalStates = 1 << m;
        dp = new int[totalStates];
        for(int i = 0; i < totalStates; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int initialState = 0;
        for (int i = 0; i < m; i++){
            if (matrix[0][i] == 1){
                initialState |= (1 << i);
            }
        }
        dp[initialState] = 0;
        for (int i = 0; i < n; i++){
            int newDp[] = new int[totalStates];
            for(int state = 0; state < totalStates; state++){
                if(dp[state] != Integer.MAX_VALUE){
                    for (int j = 0; j < m; j++){
                        int newState = getStatus(state, j);
                        newDp[newState] = Math.min(newDp[newState], dp[state] + 1);
                    }
                }
            }
            dp = newDp;
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    private static int getStatus(int rowState, int j){
        int flipMask = 1 << j;
        rowState ^= flipMask;
        if (j > 0){
            flipMask = 1 << (j - 1);
            rowState ^= flipMask;
        }
        if(j < m - 1){
            flipMask = 1 << (j + 1);
            rowState ^= flipMask;
        }
        if(n > 1){
            if (j > 0){
                flipMask = 1 << (j - 1);
                rowState ^= flipMask;
            }
            flipMask = 1 << j;
            rowState ^= flipMask;
            if(j < m - 1){
                flipMask = 1 << (j + 1);
                rowState ^= flipMask;
            }
        }
        if(n > 1){
            if (j > 0){
                flipMask = 1 << (j - 1);
                rowState ^= flipMask;
            }
            flipMask = 1 << j;
            rowState ^= flipMask;
            if(j < m - 1){
                flipMask = 1 << (j + 1);
                rowState ^= flipMask;
            }
        }
        return rowState;
    }


}
