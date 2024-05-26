import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + r;
            dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + g;
            dp[i][B] = Math.min(dp[i - 1][G], dp[i - 1][R]) + b;
        }

        System.out.println(Math.min(Math.min(dp[N][R],dp[N][G]),dp[N][B]));
    }
}

