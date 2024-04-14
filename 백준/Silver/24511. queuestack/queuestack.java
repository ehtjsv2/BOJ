import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            //queue만 넣음
            if (Integer.parseInt(st1.nextToken()) == 0) {
                queue.addLast(Integer.parseInt(st2.nextToken()));
            } else { // stack은 숫자 넣지 않음
                st2.nextToken();
            }
        }

        int C = Integer.parseInt(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            queue.addFirst(Integer.parseInt(st2.nextToken()));
            sb.append(queue.removeLast() + " ");
        }

        System.out.println(sb);
    }
}
