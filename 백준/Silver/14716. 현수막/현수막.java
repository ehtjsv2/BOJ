import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int[] di = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dj = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    answer++;
                    dfs(i, j);
                }
                visited[i][j] = true;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];

            if (nextI < 0 || nextI >= M || nextJ < 0 || nextJ >= N) {
                continue;
            }

            if (arr[nextI][nextJ] == 1 && visited[nextI][nextJ] == false) {
                dfs(nextI, nextJ);
            }
        }

    }
}
