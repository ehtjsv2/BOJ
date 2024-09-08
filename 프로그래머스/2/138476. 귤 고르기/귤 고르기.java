import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int[] count = new int[10_000_001];
        for(int i= 0;i<tangerine.length;i++){
            count[tangerine[i]]++;
        }
        
        Integer[] sortedCounts = new Integer[10_000_001];
        for (int i = 0; i <= 10_000_000; i++) {
            sortedCounts[i] = count[i];
        }
        
        Arrays.sort(sortedCounts, Comparator.reverseOrder());
            
        int answer = 0;
        for(int i=0;i<=10_000_000;i++){
            if(k<=0){
                break;
            }
            if(sortedCounts[i]>0){
                k-=sortedCounts[i];
                sortedCounts[i]=0;
                answer++;
            }
        }
        
        return answer;
    }
}