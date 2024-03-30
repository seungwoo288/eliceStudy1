package 백준문제풀이.dp;

import java.util.*;

public class LCS {
    static char[] string1;
    static char[] string2;
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        string1 = sc.nextLine().toCharArray();
        string2 = sc.nextLine().toCharArray();

        dp = new Integer[string1.length][string2.length];

        System.out.println(Solution(string1.length-1, string2.length-1));
        sc.close();
    }

    public static int Solution(int a, int b) {
        if(a == -1 || b == -1) {
            return 0;
        }

        if(dp[a][b] == null) {
            dp[a][b] = 0;

            if (string1[a] == string2[b]) {
                dp[a][b] = Solution(a - 1, b - 1) + 1;
            }
            // 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
            else {
                dp[a][b] = Math.max(Solution(a - 1, b), Solution(a, b - 1));
            }
        }
        return dp[a][b];
    }
}
