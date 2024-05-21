import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로칸의 수 X
        int N = Integer.parseInt(st.nextToken()); // 세로칸의 수 Y
        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Position> q = new ArrayDeque();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    q.add(new Position(i, j));
                    visited[i][j] = true;
                    arr[i][j] = 1;
                } else if (num == -1) {
                    visited[i][j] = true;
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            Position now = q.poll();
            int nowY = now.y;
            int nowX = now.x;
            for (int i = 0; i < 4; i++) {
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(nextY<0 || nextY>=N || nextX<0 ||nextX>=M || visited[nextY][nextX]){
                    continue;
                }
                arr[nextY][nextX] = arr[nowY][nowX]+1;
                visited[nextY][nextX] = true;
                q.add(new Position(nextY,nextX));
            }
        }

        boolean isExistZeroTomato = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .filter(r -> r == 0)
                .count() > 0;
        if(isExistZeroTomato){
            System.out.println("-1");
        }else{
            int max = Arrays.stream(arr)
                    .flatMapToInt(Arrays::stream)
                    .max()
                    .getAsInt();
            System.out.println(max-1);
        }
    }

    static class Position {
        final int y;
        final int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
