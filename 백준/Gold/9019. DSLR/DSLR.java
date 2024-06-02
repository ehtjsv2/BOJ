import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int A;
    public static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] answer = new String[10000];
            boolean[] visited = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new ArrayDeque<>();
            answer[A] = "";
            visited[A] = true;
            q.add(A);
            Arrays.fill(answer,"");
            while (!visited[B] && !q.isEmpty()) {
                int now = q.poll();
                int D = D(now);
                int S = S(now);
                int L = L(now);
                int R = R(now);

                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    answer[D] = answer[now] + "D";
                }
                if(!visited[S]){
                    q.add(S);
                    visited[S] = true;
                    answer[S] = answer[now]+"S";
                }
                if(!visited[L]){
                    q.add(L);
                    visited[L] = true;
                    answer[L] = answer[now]+"L";
                }
                if(!visited[R]){
                    q.add(R);
                    visited[R] = true;
                    answer[R] = answer[now]+"R";
                }
            }
            System.out.println(answer[B]);
        }

    }

    public static int D(int n) {
        int num = (2 * n) % 10000;
        return num;
    }

    public static int S(int n) {
        int num = n <= 0 ? 9999 : n - 1;
        return num;
    }

    public static int L(int n) {
        return (n % 1000) * 10 + n/1000;
    }

    public static int R(int n) {
        return (n % 10) * 1000 + n/10;
    }
}
