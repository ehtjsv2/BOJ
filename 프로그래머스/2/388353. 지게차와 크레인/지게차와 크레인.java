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
                        boolean[][] visited = new boolean[n][m];
                        if(request.length() == 1){
                            if(removed[i][j] == false){
                                Deque<Integer> dqI = new ArrayDeque<>();
                                Deque<Integer> dqJ = new ArrayDeque<>();
                                dqI.addLast(i);
                                dqJ.addLast(j);
                                boolean flag = false;
                                while(!dqI.isEmpty() && flag == false){
                                    int nowI = dqI.removeLast();
                                    int nowJ = dqJ.removeLast();
                                    visited[nowI][nowJ] = true;
                                    for(int k =0;k<4;k++){
                                        int nextI = nowI+di[k];
                                        int nextJ = nowJ+dj[k];
                                        if(nextI<0 || nextI>=n || nextJ<0 || nextJ>=m){
                                            removed[i][j] = true;
                                            removeTime[i][j] = time;
                                            removeCount++;
                                            flag = true;
                                            break;
                                        }
                                        if(removed[nextI][nextJ] == true && removeTime[nextI][nextJ] != time && visited[nextI][nextJ] == false){
                                            dqI.addLast(nextI);
                                            dqJ.addLast(nextJ);
                                        }
                                    }
                                }
                            }    
                        }
                        else{
                            if(removed[i][j] == false){
                                removed[i][j] = true;
                                removeTime[i][j] = time;
                                removeCount++;
                            }
                            
                        }
                        visited[i][j] = false;
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
                visited[i][j] = false;
                return true;
            }
            if(removed[nextI][nextJ] == true && removeTime[nextI][nextJ] != time && visited[nextI][nextJ] == false){
                boolean can = canRemove(nextI,nextJ, visited);
                if(can == true){
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

}