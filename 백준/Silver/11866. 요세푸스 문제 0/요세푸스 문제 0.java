import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int index = 0;
        while (!dq.isEmpty()){
            for (int i = 0; i < K-1; i++) {
                dq.addLast(dq.removeFirst());
            }
            sb.append(dq.removeFirst());
            if(!dq.isEmpty()){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
