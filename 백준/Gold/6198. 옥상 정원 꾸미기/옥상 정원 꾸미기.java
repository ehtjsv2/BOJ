import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        building = new int[N];
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = building[i];
            while (!dq.isEmpty() && dq.peekFirst() <= num) { // 다음 숫자가 더 클때까지 스택 POP
                dq.removeFirst();
            }
            answer += dq.size(); // 남은 빌딩들은 본인을 감시가능한 빌딩뿐
            dq.addFirst(num);
        }

        System.out.println(answer);
    }
}
