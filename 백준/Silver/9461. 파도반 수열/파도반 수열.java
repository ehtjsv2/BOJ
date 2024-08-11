import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static long[] dp = new long[101];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(find(N)).append("\n");
        }

        System.out.println(sb);
    }

    static long find(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = find(n - 5) + find(n - 1);
        return dp[n];
    }
}
