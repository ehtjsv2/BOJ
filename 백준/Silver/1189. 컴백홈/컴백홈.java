import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] isWall;
    static int R;
    static int C;
    static int K;
    static Position home;
    static Position start;
    static int answer = 0;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isWall = new boolean[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                if (str.charAt(j - 1) == 'T') {
                    isWall[i][j] = true;
                }
            }
        }

        start = new Position(R, 1);
        home = new Position(1, C);

        boolean[][] visited = new boolean[R + 1][C + 1];
        visited[R][1] = true;
        bt(start, visited, 1);
        System.out.println(answer);
    }

    private static void bt(Position now, boolean[][] visited, int depth) {
        if (depth > K) {
            return;
        }
        if (now.c == home.c && now.r == home.r) {
            if (depth == K) {
                answer++;
            }
            return;
        }

        int nowR = now.r;
        int nowC = now.c;

        for (int i = 0; i < 4; i++) {
            int nextR = nowR + dr[i];
            int nextC = nowC + dc[i];
            if (nextR > R || nextC > C || nextR <= 0 || nextC <= 0 || visited[nextR][nextC] == true
                    || isWall[nextR][nextC] == true) {
                continue;
            }
            visited[nextR][nextC] = true;
            boolean[][] booleans = new boolean[R + 1][C + 1];
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    booleans[j][k] = visited[j][k];
                }
            }
            bt(new Position(nextR, nextC), booleans, depth + 1);
            visited[nextR][nextC] = false;
        }
    }

    static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
