class Solution {
    
    static boolean[] visited = new boolean[31];
    static int n;
    static int[][] q;
    static int[] ans;
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        bt(0,0);
        return answer;
    }
    
    public static void bt(int depth, int beforeNum){
        if(depth == 5){
            int allMatch = 0;
            for(int i = 0;i<q.length; i++){
                int match = 0;
                for(int j= 0; j<5;j++){
                    if(visited[q[i][j]] == true){
                        match++;
                    }
                }
                if(match != ans[i]){
                    return;
                }
            }
 
            answer++;
        }
        for(int i = beforeNum+1; i <= n; i++){
            visited[i] = true;
            bt(depth+1, i);
            visited[i] = false;
        }
    }
}