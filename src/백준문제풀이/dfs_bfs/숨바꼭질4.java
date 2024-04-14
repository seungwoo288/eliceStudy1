package 백준문제풀이.dfs_bfs;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숨바꼭질4 {
    static final int MAX_SIZE = 100001;
    static boolean[] visited = new boolean[MAX_SIZE];
    static int[] parent = new int[MAX_SIZE];

    public static void BFS(int start, int K) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();

                if (current == K) {
                    System.out.println(time);
                    return;
                }
                if (current < MAX_SIZE && !visited[current + 1]) {
                    int next = current + 1;
                    q.offer(next);
                    visited[next] = true;
                    parent[next] = current;
                }
                if (current > 0 && !visited[current - 1]) {
                    int next = current - 1;
                    q.offer(next);
                    visited[next] = true;
                    parent[next] = current;
                }
                if (current * 2 <= MAX_SIZE && !visited[current * 2]) {
                    int next = current * 2;
                    q.offer(next);
                    visited[next] = true;
                    parent[next] = current;
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BFS(N, K);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        int index = K;
        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
