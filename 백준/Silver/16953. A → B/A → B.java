import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (B > A) {
            // 짝수
            if (B % 2 == 0) {
                answer++;
                B = B / 2;
            } else {// 음수
                if (B % 10 != 1) {
                    answer = -1;
                    break;
                }
                answer++;
                B = B / 10;
            }
        }
        if (answer == 0 || answer == -1 || A!=B) {
            answer = -1;
        }
        else{
            answer++;
        }
        System.out.println(answer);
    }
}
