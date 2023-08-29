import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer=0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String str = br.readLine();
            int ch_visit[]=new int[26];
            int current_visit=0;
            Boolean isAnswer=true;
            for(int j=0;j<str.length();j++){
                if(current_visit != str.charAt(j) && ch_visit[str.charAt(j)-97]==1){
                    isAnswer=false;
                    break;
                }
                current_visit=str.charAt(j);
                ch_visit[current_visit-97]=1;
            }
            if(isAnswer)answer++;
        }
        System.out.println(answer);    
    }
}