import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        Integer []num = new Integer[N.length()];

        int sum=0;
        int IsZero=0;
        int len=N.length();

        for(int i=0;i<len;i++){
            num[i]=N.charAt(i)-'0';
        }
        for(int i=0;i<len;i++){
            sum+=num[i];
            if(num[i]==0)IsZero=1;
        }

        
        if(IsZero==1 && sum%3==0){
            Arrays.sort(num, Collections.reverseOrder());
            for(int i=0;i<N.length();i++)
                System.out.print(num[i]);
        }
        else {
            System.out.println("-1");
        }
    }
}