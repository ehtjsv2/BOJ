import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] split = s.split(" ");
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<split.length; i++){
            list.add(split[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<split.length; i++){
            if(i!=split.length-1){
                sb.append(changeJadenCase(split[i])).append(" ");    
            }else{
                sb.append(changeJadenCase(split[i]));    
            }
            
        }
        if(s.replaceAll(" ","").length() == 0){
            return s;
        }
        if(s.charAt(s.length()-1) == ' '){
            sb.append(" ");
        }
        String answer =sb.toString();
        return answer;
    }
    
    public static String changeJadenCase(String s){
        String lower = s.toLowerCase();
        
        char[] chars = lower.toCharArray();
        
        if(chars.length == 0){
            return "";
        }
        
        if(chars[0]>='0' && chars[0]<='9'){
            return lower;
        }
        
        String replace = new String(""+chars[0]).toUpperCase();
        chars[0] = replace.charAt(0);
        return new String(chars);
    }
}