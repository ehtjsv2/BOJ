import java.util.*;

class Solution {
    
    public int solution(int players[], int m, int k) {
        int serverCount = 0;
        int[] timeToRemoveCount = new int[50];
        int answer = 0;
        
        for(int i = 0; i < players.length; i++){
            serverCount -= timeToRemoveCount[i];
            int remain = players[i]-(m*serverCount);
            while(remain > 0 && remain>=m){
                serverCount++;
                remain -= m;
                answer ++;
                timeToRemoveCount[i+k]++;
            }
        }
        return answer;
    }
}