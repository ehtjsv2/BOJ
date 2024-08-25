import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (dp[i + 1] > 0) {
                dp[i] = dp[i + 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
        }

        int max = -1001;
        for (int i = 0; i < N; i++) {
            if(max<dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
