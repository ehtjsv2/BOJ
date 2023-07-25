import java.util.Hashtable;

class Solution {
     public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] answer = new int[photo.length];
        for(int i=0;i<answer.length;i++)answer[i]=0;
        
        Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
        for(int i=0;i<name.length;i++) ht.put(name[i], yearning[i]);
       //  System.out.println(ht.contains(photo[0][0]));
        // System.out.println(name[0].equals(photo[0][0]));
        
        
        for(int i=0;i<photo.length;i++){
            for(int j=0;j<photo[i].length;j++){
                //System.out.println(photo[i][j]);
                if(ht.containsKey(photo[i][j])){
                   // System.out.println(ht.get(photo[i][j]));
                    answer[i]+=ht.get(photo[i][j]);
                }
            }
        }
        return answer;
    }
}