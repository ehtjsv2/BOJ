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
        long[][] arr = new long[N + 1][N + 1];
        long[][] rowSum = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                long num = Long.parseLong(st.nextToken());
                arr[i][j] = num;
                rowSum[i][j] = rowSum[i][j-1]+num;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st.nextToken());
            int startJ = Integer.parseInt(st.nextToken());
            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int j = startI; j <= endI; j++) {
                int nowI = j;
                long endSum = rowSum[nowI][endJ];
                long minus = rowSum[nowI][startJ-1];
                sum+=endSum-minus;
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }
}
