import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
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
        Arrays.fill(startCost, MAX_VALUE);
        startCost[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<Node>();
        boolean[] visited = new boolean[N + 1];
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            // 다음 방문할 노드는 제일 비용적은 인덱스
            Node now = q.poll();
            int visitIndex = now.no;
            if (visited[visitIndex]) {
                continue;
            }
            visited[visitIndex] = true;

            for (int i = 1; i <= N; i++) {
                // 현재 방문점에서 다음 노드 방문하는 것이 이전 비용보다 작다면
                if (cost[visitIndex][i] != MAX_VALUE && !visited[i] &&
                        startCost[visitIndex] + cost[visitIndex][i] < startCost[i]) {
                    startCost[i] = startCost[visitIndex] + cost[visitIndex][i];
                    q.offer(new Node(i, startCost[i]));
                }
            }
        }

        System.out.println(startCost[end]);
    }

    static class Node implements Comparable<Node> {
        int no;
        int cost;

        public Node(int index, int cost) {
            this.no = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
