package com.JK.hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-30 12:03
 */
public class Nmvp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] scores = new int[t];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            int score = sc.nextInt();
            scores[i] = score;
            map.put(score, map.getOrDefault(score, 0) + 1);
        }
        Arrays.sort(scores);
        sc.close();
        int totalScore = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            totalScore += entry.getKey() * entry.getValue();
        }
        int res = Integer.MAX_VALUE;
        for (int i = t; t >= 1; t--) {
            if (totalScore % t != 0) {
                continue;
            }
            int minScore = totalScore / t;
            if(scores[scores.length - t] > minScore){
                continue;
            }
            res = Math.min(minScore, res);
        }


        System.out.println(res);


    }
}
