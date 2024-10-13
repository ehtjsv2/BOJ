import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int[][] arr;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[2][N];
            dp = new int[2][N];
            visited = new boolean[2][N];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = Math.max(dp(0, 0), dp(1, 0));
            System.out.println(answer);
        }
    }


    public static int dp(int x, int y) {
        if (x >= 2 || y >= N) {
            return 0;
        }
        if (visited[x][y] == true) {
            return dp[x][y];
        }
        visited[x][y] = true;
        int dx = 1;
        if (x == 1) {
            dx = -1;
        }
        dp[x][y] = arr[x][y] + Math.max(dp(x + dx, y + 1), dp(x + dx, y + 2));
        return dp[x][y];
    }
}
