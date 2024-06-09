import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
3 1
 */
// 처음으로 돌아오면 visited를 초기화하는 것이 핵심
// 그리고 첫 수보다 낮은 숫자는 무시
public class Main {

    static List<String> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] list;

    static int M;
    static int N;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            list[1] = i;
            recur(2, i);
        }
        String join = String.join("\n", answer);
        System.out.println(join);
    }

    public static void recur(int depth, int firstNum) {
        if (depth == M + 1) {
            List<String> answerCandi = new ArrayList<>();
            for (int i = 1; i <= M; i++) {
                answerCandi.add(list[i] + "");
            }
            answerCandi.sort(Comparator.naturalOrder());
            String join = String.join(" ", answerCandi);
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i).equals(join)) {
                    return;
                }
            }
            answer.add(join);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && i > firstNum) {
                visited[i] = true;
                list[depth] = i;
                recur(depth + 1, firstNum);
                visited[i] = false;
            }
        }
    }
}
