import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static Map<Integer, Boolean> isDeleted = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
            isDeleted.put(i, false);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int want = Integer.parseInt(st.nextToken());
            int first = deque.getFirst();
            int rightCount = findCount(first, want, false);
            int leftCount = findCount(first, want, true);
            if (rightCount < leftCount) {
                answer += rightCount;
                while (deque.getFirst() != want) {
                    deque.addLast(deque.removeFirst());
                }
                deque.removeFirst();
            } else {
                answer += leftCount;
                while (deque.getFirst() != want) {
                    deque.addFirst(deque.removeLast());
                }
                deque.removeFirst();
            }
            isDeleted.put(want, true);
        }
        System.out.println(answer);
    }

    public static int findCount(int asIs, int toBe, boolean isLeft) {
        int next = isLeft ? -1 : 1;
        int count = 0;
        while (asIs != toBe) {
            do {
                asIs += next;
                if (asIs == 0) {
                    asIs = N;
                } else if (asIs == N + 1) {
                    asIs = 1;
                }
            }
            while (isDeleted.get(asIs) == true);
            count++;
        }
        return count;
    }
}
