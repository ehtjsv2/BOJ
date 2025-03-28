import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        Server server = new Server(m, k);
        for(int i = 0; i < players.length; i++){
            // server update
            server.returnServer(i);
            // server extends
            server.extendsServer(i,players[i]);
        }
        return server.answer;
    }
    
    
    public static class Server{
        int serverCount = 1;
        int m;
        int k;
        int answer = 0;
        PriorityQueue<ExtendServerTime> extendsTime = new PriorityQueue<>(
            (o1, o2)->{
                ExtendServerTime e1 = (ExtendServerTime) o1;
                ExtendServerTime e2 = (ExtendServerTime) o2;
                return e1.time-e2.time;
            }
        );
        
        public Server(int m, int k){
            this.m = m;
            this.k = k;
        }
        
        public void returnServer(int time){
            while(!extendsTime.isEmpty() && (extendsTime.peek().time + k) <= time){
                serverCount-=extendsTime.peek().count;
                extendsTime.remove();
            }
            
        }
        
        public void extendsServer(int time, int userCount){
            if(userCount >= (m*serverCount)){
                int needServerCount = (userCount / m) + 1;
                int extendsCount = needServerCount - serverCount;
                answer+=extendsCount;
                serverCount=needServerCount;
                extendsTime.add(new ExtendServerTime(time, extendsCount));
                System.out.println(time+", "+userCount+", "+(serverCount-1)+", "+extendsCount);
            }
            
        }
    }
    
    public static class ExtendServerTime{
        int time;
        int count;
        
        public ExtendServerTime(int t, int c){
            this.time = t;
            this.count = c;
        }
    }
}