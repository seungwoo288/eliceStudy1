package 백준문제풀이.dfs_bfs;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 탈출 {
    static int R, C;
    static char[][] map;
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> hedgehogQueue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    hedgehogQueue.offer(new int[]{i, j});
                } else if (map[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j});
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
        int time = 0;

        while (!hedgehogQueue.isEmpty()) {
            spreadWater();

            int size = hedgehogQueue.size();

            for (int i = 0; i < size; i++) {
                int[] current = hedgehogQueue.poll();
                int x = current[0];
                int y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (map[nx][ny] == 'D') return time + 1; // 비버의 굴에 도달한 경우
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S'; // 고슴도치 이동
                            hedgehogQueue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            time++;
        }

        return -1; // 탈출 불가능한 경우
    }

    static void spreadWater() {
        int size = waterQueue.size();

        for (int i = 0; i < size; i++) {
            int[] current = waterQueue.poll();
            int x = current[0];
            int y = current[1];

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*'; // 물 확장
                        waterQueue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
