import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
       int answer = 0;
        int[][] dp = new int[triangle.length+1][triangle.length];
        
        for(int i = 1; i<triangle.length+1; i++){
            for(int j = 0; j<triangle[i-1].length; j++){
                for(int k = j-1; k<j+1; k++){
                                        
                    if(k < 0) continue;
                    
                    dp[i][j] = Math.max(dp[i][j], triangle[i-1][j] + dp[i-1][k]);
                    
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        
        return answer;
    }
    
    // public static int findDp(int i, int j){
    //     if(dp[i][j] != 0){
    //         return dp[i][j];
    //     }
    //     dp[i][j] = triangle[i][j]+Math.max(findDp(i+1,j),findDp(i+1,j+1));
    //     return dp[i][j];
    // }
}