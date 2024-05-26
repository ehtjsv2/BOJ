import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        long dp[];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        dp[1] = 1;
        if(N>=2){
            dp[2] = 3;    
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * 2;
            if (dp[i] >= 10007) {
                dp[i] = dp[i] % 10007;
            }
        }
        System.out.println(dp[N] % 10007);
    }
}
