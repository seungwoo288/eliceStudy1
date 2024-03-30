package 백준문제풀이.dp;

import java.util.*;

public class 내려가기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] minDp = new int[N + 1][3];
        int[][] maxDp = new int[N + 1][3];
        for(int i = 0; i < N; i++) {
            if (i == 0) {
                maxDp[0][0] = minDp[0][0] = arr[0][0];
                maxDp[0][1] = minDp[0][1] = arr[0][1];
                maxDp[0][2] = minDp[0][2] = arr[0][2];
            }
            else {
                maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];
                maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + arr[i][1];
                maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];

                minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];
                minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + arr[i][1];
                minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[N][i]);
            max = Math.max(max, maxDp[N][i]);
        }

        System.out.println(max + " " + min);
        sc.close();
    }
}
