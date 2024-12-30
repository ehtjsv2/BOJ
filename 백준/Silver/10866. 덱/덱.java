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
        Deque<Integer> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                dq.addFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("push_back")) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop_front")) {
                if (dq.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(dq.removeFirst() + "\n");
                }
            } else if (command.equals("pop_back")) {
                if (dq.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(dq.removeLast() + "\n");
                }
            } else if (command.equals("size")) {
                sb.append(dq.size() + "\n");
            } else if (command.equals("empty")) {
                sb.append((dq.isEmpty() ? 1 : 0) + "\n");
            } else if (command.equals("front")) {
                Integer num = dq.peekFirst();
                if (num == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(num + "\n");
                }
            } else if (command.equals("back")) {
                Integer num = dq.peekLast();
                if (num == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(num + "\n");
                }
            } else {
                System.out.println("알수없는 명령어");
            }
        }
        System.out.println(sb.toString());
    }
}
