package 백준_문제_풀이;

import java.util.Scanner;

public class 자두나무 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int W = sc.nextInt();
        int[][] dp = new int[T+1][W+1];

        for(int i = 1; i <= T; i++) {
            int tree = sc.nextInt();
            for(int j = 0; j <= W; j++) {
                if(j == 0) {
                    if(tree == 1)
                        dp[i][j] = dp[i-1][j] + 1;
                    else
                        dp[i][j] = dp[i-1][j];
                    continue;
                }

                if(j % 2 == 0) {
                    if(tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                }

                else {
                    if(tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= W; i++)
            ans = Math.max(ans, dp[T][i]);

        System.out.println(ans);
    }
}
