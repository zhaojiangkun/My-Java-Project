package com.JK.hw;



import java.util.Scanner;

public class Luoxuanjuzhen {
    public static void main(String[] args) {
        // 创建一个扫描器对象以读取来自标准输入的数据
        Scanner sc = new Scanner(System.in);

        // 读取输入的数字总数和行数
        int cnt = sc.nextInt();
        int n = sc.nextInt();

        int m = 0;
        // 找到满足总数的最小列数 m
        for (int i = 1; i <= 100000; ++i) {
            if (n * i >=
                    cnt) {  // 如果当前行数和列数的乘积大于等于数字总数
                m = i;           // 设置列数为 i
                break;           // 退出循环
            }
        }

        int tot = n * m;                   // 总的矩阵大小
        int now = 1;                       // 当前填写的数字
        int[][] res = new int[n][m];       // 初始化结果矩阵
        boolean[][] vis = new
                boolean[n][m]; // 访问标记矩阵，记录已访问的位置
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 方向数组，定义四个方向
        int k = 0;                         // 方向索引
        int x = 0, y = 0;                  // 初始位置

        // 按螺旋顺序填充矩阵
        for (int turn = 0; turn < tot; ++turn) {
            res[x][y] = now;               // 将当前数字填入矩阵
            now += 1;                      // 增加当前数字
            if (now > cnt) {
                now = -999999;             // 超出范围后标记为一个负值
            }
            vis[x][y] = true;              // 标记当前位置已访问

            // 计算下一个坐标
            int dx = x + dir[k][0];
            int dy = y + dir[k][1];

            // 检查边界条件和访问状态
            if (dx < 0 || dx >= n || dy < 0 || dy >= m || vis[dx][dy]) {
                k = (k + 1) % 4;           // 改变方向
            }

            // 更新到下一个位置
            x += dir[k][0];
            y += dir[k][1];
        }

        // 输出结果矩阵
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j != 0) {
                    System.out.print(" "); // 添加空格用于分隔数字
                }
                if (res[i][j] < 0) {
                    System.out.print("*"); // 使用 * 号填充负数位置
                    continue;
                }
                System.out.print(res[i][j]); // 输出实际数字
            }
            System.out.println();           // 换行
        }
    }
}