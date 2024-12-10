import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long T;
    static long[][] dp = new long[65][10]; // [][0]는 해당 자릿수의 DP값


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dp[1][0] = 10;
        dp[2][0] = 55;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = i;
            dp[2][i] = 10-i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(findDp(N, 0) + "\n");
        }

        System.out.println(sb);
    }

    private static long findDp(int n, int index) {
        if (dp[n][index] != 0) {
            return dp[n][index];
        }
        dp[n][1] = findDp(n - 1, 0) - findDp(n - 2, 0);
        dp[n][0]+=findDp(n-1,0)+dp[n][1];
        for (int i = 2; i <= 9; i++) {
            dp[n][i] = findDp(n,i-1) - findDp(n-1,i-1);
            dp[n][0]+=dp[n][i];
        }
        return dp[n][0];
    }
}
