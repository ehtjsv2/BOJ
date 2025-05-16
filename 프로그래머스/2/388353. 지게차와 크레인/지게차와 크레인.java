import java.util.*;

class Solution {
    
    static int n;
    static int m;
    static char[][] stg;
    static boolean[][] removed;
    static int[][] removeTime;
    static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    static int time = 0;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        stg = new char[n][m];
        removed = new boolean[n][m];
        removeTime = new int[n][m];
        boolean[][] visited = new boolean[n][m];    
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                stg[i][j] = storage[i].charAt(j);
            }
        }
        int answer = 0;
        int removeCount = 0;
        
        
        for(String request : requests){
            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(stg[i][j] == request.charAt(0)){
                        for(int k = 0;k<n;k++){
                            Arrays.fill(visited[k], false);
                        }
                        visited[i][j] = true;
                        if(request.length() == 1){
                            if(removed[i][j] == false && canRemove(i,j,visited)){
                                removed[i][j] = true;
                                removeTime[i][j] = time;
                                removeCount++;
                            }    
                        }
                        else{
                            if(removed[i][j] == false){
                                removed[i][j] = true;
                                removeTime[i][j] = time;
                                removeCount++;
                            }
                            
                        }
                    }
                }
            }
            time++;
        }
        
        
        return n*m-removeCount;
    }
    
    public static boolean canRemove(int i, int j, boolean[][] visited){
        visited[i][j] = true;
        for(int k = 0; k<4; k++){
            int nextI = i+di[k];
            int nextJ = j+dj[k];
            if(nextI<0 || nextI>=n || nextJ<0 || nextJ>=m){
                return true;
            }
            if(removed[nextI][nextJ] == true && removeTime[nextI][nextJ] != time && visited[nextI][nextJ] == false){
                boolean can = canRemove(nextI,nextJ, visited);
                if(can == true){
                    return true;
                }
            }
        }
        return false;
    }

}