import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int answer=0;

        while(N>=2 && M>=1){
            N-=2;
            M--;
            answer++;
        }
        while(K!=0){
            if((N+M)>=K)break;
            else{
                answer--;
                N+=2;
                M++;
            }
        }
        System.out.println(answer);
    }
}
