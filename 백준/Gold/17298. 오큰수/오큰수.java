import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> dq;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dq = new ArrayDeque<>();
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int j = i;
            while (!dq.isEmpty() && dq.peekFirst() < num) {
                int answerIndex = findAnswerIndex(j);
                answer[answerIndex] = num;
                dq.removeFirst();
                j--;
            }
            dq.addFirst(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (answer[i] == 0) {
                sb.append(-1).append(" ");
            }
            else{
                sb.append(answer[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int findAnswerIndex(int i) {
        while (answer[i - 1] != 0) {
            i--;
        }
        return i - 1;
    }
}
