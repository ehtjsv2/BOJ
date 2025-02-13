import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        long answer = 0;
        int beforeNode = 0;
        int nextNode = 1;
        for (int i = 0; i < N; i++) {
            visited[nextNode] = true;
            answer+=cost[beforeNode][nextNode];
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                if(visited[j] == true){
                    for (int k = 1; k <= N; k++) {
                        if(visited[k]==false && minCost>cost[j][k]){
                            minCost = cost[j][k];
                            beforeNode = j;
                            nextNode = k;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
