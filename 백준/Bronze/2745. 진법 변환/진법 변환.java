import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i=0;i<N.length();i++){
            int ch=N.charAt(N.length()-1-i);
            if(ch>=65)ch-=55;
            else{
                ch-=48;
            }
            sum += ch*(Math.pow(B, i));
        }
        System.out.println(sum);
    }
}