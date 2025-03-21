import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int MAX = 130;
        int[][] dp = new int[info.length + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= info.length; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                if (j + b < m) {
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }

        int answer = MAX;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }

        return answer < n ? answer : -1;
    }
}