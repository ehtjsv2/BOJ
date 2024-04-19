import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }
        int groupCount = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                groupCount++;
                dfs(i);
            }
        }
        System.out.println(groupCount);
    }

    private static void dfs(int visitIndex) {
        visited[visitIndex] = true;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && arr[visitIndex][i] == true) {
                dfs(i);
            }
        }
    }
}
