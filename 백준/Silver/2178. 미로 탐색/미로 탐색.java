import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dN = {1, 0, -1, 0};
    static int[] dM = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        boolean[][] graph = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '1') {
                    graph[i][j] = true;
                } else {
                    graph[i][j] = false;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new Node(0, 0, 1));

        int answer = 0;
        while (!q.isEmpty()) {
            Node visit = q.poll();
            int visitN = visit.n;
            int visitM = visit.m;
            if (visitN == N-1 && visitM == M-1) {
                answer = visit.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextN = visitN + dN[i];
                int nextM = visitM + dM[i];
                if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M) {
                    continue;
                }
                if (visited[nextN][nextM] == false && graph[nextN][nextM] == true) {
                    visited[nextN][nextM] = true;
                    q.add(new Node(nextN, nextM, visit.count + 1));
                }
            }
        }
        System.out.println(answer);
    }

    public static class Node {
        int n;
        int m;
        int count;

        public Node(int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
