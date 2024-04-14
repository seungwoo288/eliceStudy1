package 백준문제풀이.dfs_bfs;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 인구_이동 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (movePopulation()) {
            count++;
            visited = new boolean[N][N]; // 매 이동마다 방문 여부 초기화
        }

        System.out.println(count);
    }

    static boolean movePopulation() {
        boolean moved = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    List<int[]> union = new ArrayList<>();
                    union.add(new int[]{i, j});

                    int totalPopulation = map[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                                int diff = Math.abs(map[x][y] - map[nx][ny]);
                                if (diff >= L && diff <= R) {
                                    union.add(new int[]{nx, ny});
                                    totalPopulation += map[nx][ny];
                                    queue.offer(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                    if (union.size() > 1) {
                        int newPopulation = totalPopulation / union.size();
                        for (int[] country : union) {
                            map[country[0]][country[1]] = newPopulation;
                        }
                        moved = true;
                    }
                }
            }
        }

        return moved;
    }
}

