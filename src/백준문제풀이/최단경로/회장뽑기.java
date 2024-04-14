package 백준문제풀이.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 회장뽑기 {
    static final int INF = 100;
    static int[][] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list  = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) list [i][j] = 0;
                else list [i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            list [a][b] = 1;
            list [b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (list [i][j] > list [i][k] + list [k][j]) {
                        list [i][j] = list [i][k] + list [k][j];
                    }
                }
            }
        }

        int[] scores = new int[N + 1];
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                scores[i] = Math.max(scores[i], list [i][j]);
            }
            minScore = Math.min(minScore, scores[i]);
        }

        // 최소 점수를 가진 후보 찾기
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(candidates.size()).append("\n");
        for (int candidate : candidates) {
            sb.append(candidate).append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    }
}
