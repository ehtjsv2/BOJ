import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int size = N - K;

        Deque<Integer> dq = new ArrayDeque<>();

        String numString = br.readLine();
        for (int i = 0; i < N; i++) {
            int num = numString.charAt(i) - '0';
            if (dq.isEmpty()) {
                dq.push(num);
            } else {
                int remainSize = size - dq.size();
                int remainNumberSize = N - i;
                while (!dq.isEmpty() && remainNumberSize > remainSize && num > dq.peek()) {
                    dq.pop();
                    remainSize++;
                }
                dq.push(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(dq.removeLast());
        }
        System.out.println(sb);
    }
}
