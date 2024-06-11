import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] list;

    static StringBuilder sb = new StringBuilder();
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[1] = i;
            recur(2, i);
        }
        System.out.println(sb);
    }

    public static void recur(int depth, int firstNum) {
        if (depth == M + 1) {
            List<String> answerCandi = new ArrayList<>();
            for (int i = 1; i <= M; i++) {
                answerCandi.add(list[i] + "");
            }
            String join = String.join(" ", answerCandi);
            sb.append(join+"\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
                list[depth] = i;
                recur(depth + 1, firstNum);
        }
    }
}
