import java.util.*;

class Solution {
    
    static int[][] dp = new int[500][500];
    static int height;
    static int[][] triangle;
    
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        height = triangle.length;
        for(int i=0; i<triangle[height-1].length; i++){
            dp[height-1][i] = triangle[height-1][i];
        }
        int answer = findDp(0,0);
        return answer;
    }
    
    public static int findDp(int i, int j){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        dp[i][j] = triangle[i][j]+Math.max(findDp(i+1,j),findDp(i+1,j+1));
        return dp[i][j];
    }
}
