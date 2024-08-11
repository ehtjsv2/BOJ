import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                    continue;
                }
                cost[i][j] = MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost2 = Integer.parseInt(st.nextToken());
            cost[start][end] = Integer.min(cost[start][end], cost2);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] startCost = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            startCost[i] = cost[start][i];
        }

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            // 다음 방문할 노드는 제일 비용적은 인덱스
            int visit = findMinCostIndex(startCost, visited);
            visited[visit] = true;

            for (int j = 1; j <= N; j++) {
                if(visited[j] == false){
                    // 현재 방문점에서 다음 노드 방문하는 것이 이전 비용보다 작다면
                    if (startCost[visit] + cost[visit][j] >= 0 && startCost[visit] + cost[visit][j] < startCost[j]) {
                        startCost[j] = startCost[visit] + cost[visit][j];
                    }
                }
            }

        }

        System.out.println(startCost[end]);
    }

    private static int findMinCostIndex(int[] startCost, boolean[] visited) {
        int min = MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                if (startCost[i] < min) {
                    min = startCost[i];
                    minIndex = i;
                }
            }

        }
        return minIndex;
    }
}
