import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        int now = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int wantNum = Integer.parseInt(br.readLine());
            if (wantNum >= now) {
                while (wantNum >= now) {
                    dq.push(now++);
                    sb.append("+\n");
                }
                dq.pop();
                sb.append("-\n");
            } else {
                if (dq.peek() == wantNum) {
                    dq.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);

    }
}
