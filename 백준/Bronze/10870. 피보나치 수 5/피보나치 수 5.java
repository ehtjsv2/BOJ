import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int answer = fibo(N);
        System.out.println(answer);
    }

    static int fibo(int N){
        if(N==0)return 0;
        else if(N==1)return 1;
        return fibo(N-1)+fibo(N-2);
    }
}