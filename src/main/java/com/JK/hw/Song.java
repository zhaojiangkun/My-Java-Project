package com.JK.hw;

import java.util.*;

/**
 * @Author: ZhaoJiangKun
 * @Date: 2024-10-30 12:27
 */
public class Song {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] cityNumbers = new int[n + 1];
        for (int i = 0; i < cityNumbers.length; i++) {
            cityNumbers[i] = sc.nextInt();
        }
        //天数和
        int sum = 0;
        for (int i = 0; i < cityNumbers.length; i++) {
            sum += cityNumbers[i];
        }

        t = t - sum;

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            while (m >= 0) {
                arr.add(m);
                m = m - d;
            }
        }
        Collections.sort(arr, Collections.reverseOrder());

        t = Math.max(0, t);
        int res = 0;
        for(int i = 0; i < t && i < arr.size(); i++){
            res += arr.get(i);
        }
        System.out.println(res);


        sc.close();
    }
}
