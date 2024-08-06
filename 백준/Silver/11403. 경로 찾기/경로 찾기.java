import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] v;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                v[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            int pass = i;
            visited[i] = true;
            for (int j = 1; j <= N; j++) {
                if (pass == j) {
                    continue;
                }
                for (int k = 1; k <= N; k++) {
                    if (v[j][k] == 0) {
                        if (v[j][pass] ==1 && v[pass][k] == 1) {
                            v[j][k] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }
}
