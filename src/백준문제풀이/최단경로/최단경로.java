package 백준문제풀이.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {

    static final int INF = 99999999;
    static final int MAX = 20010;

    static int V, E, start;
    static int[] Dist = new int[MAX];
    static ArrayList<ArrayList<Pair>> Vertex = new ArrayList<>();

    static class Pair {
        int vertex;
        int cost;

        Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static void DijkstraUsingHeap() {
        PriorityQueue<Pair> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        PQ.add(new Pair(start, 0));
        Dist[start] = 0;

        while (!PQ.isEmpty()) {
            Pair top = PQ.poll();
            int Cost = top.cost;
            int Cur = top.vertex;
            for (int i = 0; i < Vertex.get(Cur).size(); i++) {
                int Next = Vertex.get(Cur).get(i).vertex;
                int nCost = Vertex.get(Cur).get(i).cost;
                if (Dist[Next] > Cost + nCost) {
                    Dist[Next] = Cost + nCost;
                    PQ.add(new Pair(Next, Dist[Next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (Dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(Dist[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++)
            Vertex.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Vertex.get(a).add(new Pair(b, c));
        }

        for (int i = 1; i <= V; i++)
            Dist[i] = INF;

        DijkstraUsingHeap();
    }
}
