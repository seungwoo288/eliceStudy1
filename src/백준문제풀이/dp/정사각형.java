package 백준문제풀이.dp;

import java.util.Scanner;

public class 정사각형 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input.substring(j, j + 1));
            }
        }
        System.out.println(solution(arr));
        sc.close();
    }

    public static int solution(int[][] arr) {
        int ans = 0;

        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j] = arr[i][j];
                if (i >= 1 && j >= 1 && arr[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans*ans;
    }
}
