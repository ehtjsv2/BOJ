import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[] parent = new int[N + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            parent[child] = p;
        }

        int[][] parentCount = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            int now = i;
            for (int j = 1; j <= N; j++) {
                if (parent[now] != 0) {
                    parentCount[i][j] = parent[now];
                    now = parent[now];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (parentCount[y][i] == x) {
                System.out.println(i);
                return;
            }
            if (parentCount[x][i] == y) {
                System.out.println(i);
                return;
            }
        }

        for (int i = 1; i <= N; i++) {
            int xParent = parentCount[x][i];
            if (xParent == 0) {
                continue;
            }
            for (int j = 1; j <= N; j++) {
                int yParent = parentCount[y][j];
                if (xParent == yParent) {
                    System.out.println(i + j);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
