import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Comparator.naturalOrder());

        boolean[] visited = new boolean[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            bt(2, visited, String.valueOf(arr.get(i)));
        }
    }

    public static void bt(int depth, boolean[] visited, String str) {
        boolean[] copyVisited = visited.clone();
        if (depth > M) {
            System.out.println(str);
            return ;
        }
        for (int i = 0; i < N; i++) {
            if (copyVisited[i] == false) {
                copyVisited[i] = true;
                bt(depth + 1, copyVisited, str + " " + arr.get(i));
            }
        }
    }
}
