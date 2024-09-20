
import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> indexOfWant = new HashMap<>();
        for(int i=0; i<want.length; i++){
            indexOfWant.put(want[i],i);
        }
        
        int[] wantsOfDay = new int[want.length];
        for(int i=0; i<discount.length; i++){
            // 이전 날 개수 빼기
            if(i>=10 && indexOfWant.containsKey(discount[i-10])){
                wantsOfDay[indexOfWant.get(discount[i-10])]--;
            }
            
            // 현재 날 개수 더하기
            if(indexOfWant.containsKey(discount[i])){
                
                wantsOfDay[indexOfWant.get(discount[i])]++;
            }
            
            // 개수 충족하는 지 확인
            boolean isAnswer = true;
            for(int j=0; j<want.length; j++){
                if(wantsOfDay[j] < number[j]){
                    isAnswer = false;
                    break;
                }
            }
            if(isAnswer == true){
                answer++;
            }
        }
        return answer;
    }
}