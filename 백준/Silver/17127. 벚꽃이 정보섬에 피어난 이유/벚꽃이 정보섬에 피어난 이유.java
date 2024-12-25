import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }


        int max = 0;
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if(i==j){
                    int sum2 = 1;
                    for (int k = j; k <= j+(N-4); k++) {
                        sum2*=tree[k];
                    }
                    sum+=sum2;
                    j=j+(N-4);
                }
                else{
                    sum+=tree[j];
                }
            }
            if(max<sum){
                max = sum;
            }
        }
        System.out.println(max);
    }
}