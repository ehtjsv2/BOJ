import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static final int MOVABLE = 0;
    static final int NO_MOVABLE = -1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 목적지 -> -1, 갈 수 있는 땅 -> 0, 못가는 땅 -> -2
        arr = new int[N][M];
        visited = new boolean[N][M];
        Position destPosition = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    destPosition = new Position(i, j);
                } else if (num == 1) {
                    arr[i][j] = MOVABLE;
                } else {
                    visited[i][j] = true;
                    arr[i][j] = NO_MOVABLE;
                }
            }
        }
        Queue<Position> q = new ArrayDeque<>();
        q.add(destPosition);
        visited[destPosition.y][destPosition.x] = true;
        while (!q.isEmpty()) {
            Position now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX]
                        || arr[nextY][nextX] == NO_MOVABLE) {
                    continue;
                }
                arr[nextY][nextX] = arr[y][x] + 1;
                visited[nextY][nextX] = true;
                q.add(new Position(nextY, nextX));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = arr[i][j];
                if(i == destPosition.y && j == destPosition.x){
                    sb.append("0 ");
                }
                else if (num == NO_MOVABLE) {
                    sb.append("0 ");
                } else if (num == MOVABLE) {
                    sb.append("-1 ");
                } else {
                    sb.append(arr[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}