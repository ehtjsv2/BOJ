import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 0; j < N; j++) {
                if(answer[j] == 0 && count == num){
                    answer[j] = i;
                    break;
                }
                if(answer[j] == 0){
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            sb.append(answer[i] + " ");
        }
        sb.append(answer[N - 1]);

        System.out.println(sb);
    }
}
