import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int dx[] = {1, 0, -1, 0};
    static final int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        char[][] arr = new char[y + 1][x + 1];
        boolean[][] visited = new boolean[y + 1][x + 1];
        Position I = null;
        for (int i = 1; i <= y; i++) {
            String str = br.readLine();
            for (int j = 1; j <= x; j++) {
                char c = str.charAt(j - 1);
                if (c == 'I') {
                    I = new Position(i, j);
                }
                arr[i][j] = str.charAt(j - 1);
            }
        }
        
        int answer = 0;
        Queue<Position> q = new ArrayDeque<>();
        visited[I.y][I.x] = true;
        q.add(I);

        while (!q.isEmpty()) {
            Position now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                if (nextX <= 0 || nextX > x || nextY <= 0 || nextY > y || arr[nextY][nextX] == 'X') {
                    continue;
                }
                if (visited[nextY][nextX] == false) {
                    if (arr[nextY][nextX] == 'P') {
                        answer++;
                    }
                    visited[nextY][nextX] = true;
                    q.add(new Position(nextY, nextX));
                }
            }
        }

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }

    }

    static class Position {
        int y;
        int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
