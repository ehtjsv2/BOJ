import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int leftCount = 0;
        
        String[] inputs = s.split("");
        for(int i=0; i<inputs.length; i++){
            if(inputs[i].equals("(")){
                leftCount++;
            }
            if(inputs[i].equals(")")){
                if(leftCount == 0){
                    answer = false;
                    break;
                }
                leftCount--;
            }
        }

        if(leftCount!=0){
            answer = false;
        }
        return answer;
    }
}