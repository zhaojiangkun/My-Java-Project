package com.JK.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * mvp争夺战，
 *
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-30 10:53
 */
public class Mvp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            int score = sc.nextInt();
            map.put(score, map.getOrDefault(score, 0) + 1);
        }
        sc.close();

        int playerNumbers = map.size();
        int totalScore = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            totalScore += entry.getKey() * entry.getValue();
        }
        int minScore = totalScore / playerNumbers;
        if (totalScore % playerNumbers != 0) {
            minScore++;
        }
        System.out.println(minScore);


    }
}
