import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        dp = new String[13];
        dp[0] = "-";
        dp[1] = "- -";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb.append(findDp(N)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static String findDp(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        String beforeDp = findDp(n - 1);
        dp[n] = beforeDp + " ".repeat(beforeDp.length()) + beforeDp;
        return dp[n];
    }
}
