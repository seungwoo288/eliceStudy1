package 백준문제풀이.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 민준이_건우 {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] list;
    static int V, E, P;

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int minDist = bfs(1, V);
        int toP = bfs(1, P);
        int fromP = bfs(P, V);

        if (minDist == toP + fromP) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }

        br.close();
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        list = new int[V + 1];
        Arrays.fill(list, INF);
        list[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Edge next : graph.get(current)) {
                if (list[next.to] > list[current] + next.weight) {
                    list[next.to] = list[current] + next.weight;
                    queue.offer(next.to);
                }
            }
        }

        return list[end];
    }
}

