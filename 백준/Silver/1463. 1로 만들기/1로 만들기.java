import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer dp[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        dp = new Integer[x + 1];
        dp[0]=dp[1]=0;
        int answer = fun(x);
        System.out.println(answer);
        
    }

    public static int fun(int num) {
        if (dp[num] == null) {
            if (num % 6 == 0) {
                dp[num] = Math.min(fun(num / 3), fun(num / 2)) + 1;
            } else if (num % 3 == 0) {
                dp[num] = Math.min(fun(num / 3), fun(num - 1)) + 1;
            } else if (num % 2 == 0) {
                dp[num] = Math.min(fun(num / 2), fun(num - 1)) + 1;
            } else
                dp[num] = 1 + fun(num - 1);
        }
        return dp[num];
    }
}