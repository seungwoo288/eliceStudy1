package 백준문제풀이.최단경로;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숨바꼭질3 {
    static final int MAX_SIZE = 100000;
    static boolean[] visited = new boolean[MAX_SIZE + 1];

    static class Node {
        int current;
        int time;

        public Node(int current, int time) {
            this.current  = current;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = BFS(N, K);
        System.out.println(answer);

        br.close();
    }

    public static int BFS(int start, int K) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int current = node.current;
            int time = node.time;

            if (current == K) {
                return time;
            }
            if (current * 2 <= MAX_SIZE && !visited[current * 2]) {
                q.offer(new Node(current * 2, time));
                visited[current * 2] = true;
            }
            if (current - 1 >= 0 && !visited[current - 1]) {
                q.offer(new Node(current - 1, time + 1));
                visited[current - 1] = true;
            }
            if (current + 1 <= MAX_SIZE && !visited[current + 1]) {
                q.offer(new Node(current + 1, time + 1));
                visited[current + 1] = true;
            }
        }
        return -1;
    }
}
