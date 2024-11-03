class Solution {
    
    static int R = 17;
    static int T = 19;
    static int C = 2;
    static int F = 5;
    static int J = 9;
    static int M = 12;
    static int A = 0;
    static int N = 13;
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    // 01234567890123456789012345
    
    public String solution(String[] survey, int[] choices) {
        System.out.println((int)survey[0].charAt(0)-'A');
        int[] count = new int[26];
        
        for(int i=0; i<choices.length; i++){
            int num = choices[i];
            if(num == 1){
                count[survey[i].charAt(0)-'A']+=3;
            }else if(num == 2){
                count[survey[i].charAt(0)-'A']+=2;
            }else if(num == 3){
                count[survey[i].charAt(0)-'A']+=1;
            }else if(num == 5){
                count[survey[i].charAt(1)-'A']+=1;
            }else if(num == 6){
                count[survey[i].charAt(1)-'A']+=2;
            }else if(num == 7){
                count[survey[i].charAt(1)-'A']+=3;
            }else{
                continue;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(count[R]>=count[T]){
            sb.append("R");
        }else{
            sb.append("T");
        }
        
        if(count[C]>=count[F]){
            sb.append("C");
        }else{
            sb.append("F");
        }
        
        if(count[J]>=count[M]){
            sb.append("J");
        }else{
            sb.append("M");
        }
        
        if(count[A]>=count[N]){
            sb.append("A");
        }else{
            sb.append("N");
        }
        String answer = sb.toString();
        return answer;
    }
}