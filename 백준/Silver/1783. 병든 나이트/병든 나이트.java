import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 세로
        int M = Integer.parseInt(st.nextToken());// 가로
        int travel = sol(N,M);

        System.out.println(travel);
    }

    public static int sol(int N, int M){
        int travel=0;
        if(N<=1){
            return 1;
        }
        else if(N<=2){
            if((M+1)/2<4){
                return (M+1)/2;
            }
            else return 4;
        }
        else if(M<7){
            if(M<4){
                return M;
            }
            else return 4;
        }
        else{
            return M-2;
        }
    }
    
}