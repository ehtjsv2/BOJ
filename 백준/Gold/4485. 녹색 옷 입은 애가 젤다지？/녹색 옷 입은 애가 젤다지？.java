import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[][] arr = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int[][] cost = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int visitIdY = 0;
            int visitIdX = 0;
            cost[0][0] = arr[0][0];
            while(true){
                visited[visitIdY][visitIdX] = true;
                for (int i = 0; i < 4; i++) {
                    int nearIdy = visitIdY + dy[i];
                    int nearIdx = visitIdX + dx[i];
                    if (nearIdy < 0 || nearIdy > N - 1 || nearIdx < 0 || nearIdx > N - 1) {
                        continue;
                    }
                    if (cost[nearIdy][nearIdx] > cost[visitIdY][visitIdX] + arr[nearIdy][nearIdx]) {
                        cost[nearIdy][nearIdx] = cost[visitIdY][visitIdX] + arr[nearIdy][nearIdx];
                    }
                }

                int minCost = Integer.MAX_VALUE;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(cost[i][j] < minCost && visited[i][j] == false){
                            minCost = cost[i][j];
                            visitIdY = i;
                            visitIdX = j;
                        }
                    }
                }

                if(minCost == Integer.MAX_VALUE){
                    break;
                }
            }
            System.out.printf("Problem %d: %d\n",problemNum++,cost[N-1][N-1]);
        }
    }
}
