import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long answer;
        long maxGongYak = 0;
        long higher;
        long lower;
        if (A > B) {
            higher = A;
            lower = B;
        } else {
            higher = B;
            lower = A;
        }

        while (true) {
            if (higher % lower == 0) {
                maxGongYak = lower;
                break;
            }
            higher = higher % lower;
            long tmp = higher;
            higher = lower;
            lower = tmp;
        }
        long c = A / maxGongYak;
        long d = B / maxGongYak;
        System.out.println(maxGongYak * c * d);
    }
}