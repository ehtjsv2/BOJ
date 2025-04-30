import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String,Boolean> HM = new HashMap<String,Boolean>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String S[] =new String[N];
        String test[] = new String[M];
        for(int i=0;i<N;i++)HM.put(br.readLine(),true);
        for(int i=0;i<M;i++)test[i]=br.readLine();

        int answer=0;
        for(int i=0;i<M;i++){
            if(HM.containsKey(test[i]))answer++;
        }
        System.out.println(answer);
    }
}