import java.util.*;

class Solution {
    public String solution(String s) {
        String[] splits = s.split(" ");
        List<Integer> splitInts = new ArrayList<>();
        for(int i=0; i<splits.length; i++){
            splitInts.add(Integer.parseInt(splits[i]));
        }
        splitInts.sort(Comparator.naturalOrder());
        
        
        String answer = splitInts.get(0) +" "+splitInts.get(splitInts.size()-1);
        return answer;
    }
}