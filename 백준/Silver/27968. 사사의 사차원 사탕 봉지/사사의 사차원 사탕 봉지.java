import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sum = new long[M + 1];
        st = new StringTokenizer(br.readLine());
        sum[1] = Long.parseLong(st.nextToken());
        for (int i = 2; i <= M; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            long want = Long.parseLong(br.readLine());

            int l = 1;
            int r = M;
            while (l < r) {
                int m = (l + r) / 2;
                if(sum[m]<want){
                    l=m+1;
                }
                else{
                    r=m;
                }
            }

            if(sum[l]<want){
                System.out.println("Go away!");
            }
            else{
                System.out.println(l);
            }
        }
    }
}
