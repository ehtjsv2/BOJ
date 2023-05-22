import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] rope=new int[N];
        int result = 0;
        for(int i=0;i<N;i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(rope);
        // rope[i]*N-i가 이전 result보다 크다면 대체
        for(int i=0;i<N;i++){
            int weight = rope[i]*(N-i);
            if(weight>result)result=weight;
        }
        System.out.println(result);
    }
}