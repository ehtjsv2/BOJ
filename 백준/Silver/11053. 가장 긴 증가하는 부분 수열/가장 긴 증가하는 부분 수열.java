import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[N - 1] = 1;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (findDp(i) > max) {
                max = findDp(i);
            }
        }

        System.out.println(max);
    }

    static int findDp(int i) {
        if (dp[i] != 0) {
            return dp[i];
        }
        for (int j = i; j < N; j++) {
            if (arr[j] > arr[i]) {
                if (findDp(j) >= dp[i]) {
                    dp[i] = 1 + findDp(j);
                }
            }
        }
        if (dp[i] == 0) {
            dp[i] = 1;
        }
        return dp[i];
    }
}
