import java.util.Hashtable;

class Solution {
    public static String[] solution(String[] players, String[] callings) {

        String[] answer = new String[players.length];
        Hashtable<String,Integer> ht=new Hashtable<String,Integer>();
        String[] rank = new String[players.length];
        for(int i=0;i<players.length;i++){
            ht.put(players[i],i);
            rank[i]=players[i];
        }
        for(int i=0;i<callings.length;i++){
            //불린 이름의 랭킹조회
            int callRanking = ht.get(callings[i]);
            //불린 이름의 앞사람 이름 조회
            String frontString = rank[callRanking-1];
            //앞사람의 랭킹 변경
            ht.replace(frontString, callRanking);
            rank[callRanking]=frontString;
            //불린사람의 랭킹 변경
            ht.replace(callings[i], callRanking-1);
            rank[callRanking-1]=callings[i];
        }

        for(int i=0;i<players.length;i++){
            answer[i]=rank[i];
        }

        
        return answer;
    }
}