import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        int[] answer = new int[N];
        Arrays.fill(answer,-1);
        Deque<Integer> order = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekFirst() < num) {
                answer[order.removeFirst()] = num;
                dq.removeFirst();
            }
            dq.addFirst(num);
            order.addFirst(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
