import java.util.*;

class Solution {
    
    public static ArrayDeque<Integer> q1;
    public static ArrayDeque<Integer> q2;
    public static long sum1;
    public static long sum2;
    
    
    public int solution(int[] queue1, int[] queue2) {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        sum1 = 0;
        sum2 = 0;
        
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1+=queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2+=queue2[i];
        }
        
        long sum3 = sum1+sum2;
        if(sum3 % 2 == 1){
            return -1;
        }
        
        int answer = 0;
        while(sum1!=sum2) {
            // System.out.println("q1 = "+sum1+", q2 ="+sum2);
            if(sum1 > sum2){
                // System.out.println("q1pop");
                q1pop();
            }
            else{
                // System.out.println("q2pop");
                q2pop();
            }
            
            if(q1.size() == 0 || q2.size() == 0){
                // System.out.println("0이다");
            
                return -1;
            }
            
            answer++;
            if(answer > 300_001){
                return -1;
            }
        }
        
        return answer;
    }
    
    public static void q1pop(){
        int num = q1.removeFirst();
        sum1-=num;
        sum2+=num;
        q2.addLast(num);
        
    }
    
    public static void q2pop(){
        int num = q2.removeFirst();
        sum2-=num;
        sum1+=num;
        q1.addLast(num);
    }
}