import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String str= br.readLine();
            int len = str.length();
            int cnt=0;
            for(int j=0;j<len;j++){
                if(str.charAt(j)=='(') cnt++;
                else cnt--;
                if(cnt<0 || (j==len-1&&cnt!=0)){
                    break;
                }
            }
            if(cnt==0)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}