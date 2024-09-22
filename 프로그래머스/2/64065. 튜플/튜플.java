import java.util.*;

class Solution {
    public int[] solution(String s) {
        s=s.replaceAll("\\{","");
        s=s.replaceAll("}","");
        String[] splitS = s.split(",");
        Map<String, Integer> counts = new HashMap<>();
        
        for(int i=0; i<splitS.length; i++){
            if(counts.containsKey(splitS[i]) == false){
                counts.put(splitS[i],1);
            }
            else{
                counts.replace(splitS[i],counts.get(splitS[i])+1);
            }
        }
        
        Map<Integer, String> numOfCount = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : counts.entrySet()){
            list.add(entry.getValue());
            numOfCount.put(entry.getValue(), entry.getKey());
        }
        Collections.sort(list, Comparator.reverseOrder());
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(numOfCount.get(list.get(i)));
        }
        return answer;
    }
}