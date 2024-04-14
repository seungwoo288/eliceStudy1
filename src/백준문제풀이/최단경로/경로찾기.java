package 백준문제풀이.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로찾기 {
    static ArrayList<Integer>[] v;
    static int[] visit;

    public static void dfs(int x) {
        for (int i = 0; i < v[x].size(); i++) {
            int next = v[x].get(i);
            if (visit[next] == 0) {
                visit[next] = 1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        v = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            v[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) v[i].add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            visit = new int[n];
            dfs(i);
            for (int j = 0; j < n; j++)
                System.out.print(visit[j] + " ");
            System.out.println();
        }

        br.close();
    }
}
