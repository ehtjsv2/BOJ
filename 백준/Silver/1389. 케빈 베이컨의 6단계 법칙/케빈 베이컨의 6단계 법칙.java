import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int targetV = Integer.parseInt(st.nextToken());
            int connectV = Integer.parseInt(st.nextToken());
            arr.get(targetV).add(connectV);
            arr.get(connectV).add(targetV);
        }

        int[][] a = new int[N + 1][N + 1];
        int[] answer = new int[N + 1];
        answer[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
//            System.out.println("================");
//            System.out.println("첫 시작 노드 : "+i);
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> q = new ArrayDeque<Integer>();

            q.add(i);
            int roundCount = 0;
            while (!q.isEmpty()) { // 다음 라운드에 방문할 노드가 있는지
                roundCount++;
//                System.out.println("라운드 카운트 : "+roundCount);
                Queue<Integer> q2 = new ArrayDeque<>(q);
                q.clear();
                while (!q2.isEmpty()) { // 이번 라운드 노드 방문
                    int visitV = q2.poll();
                    if (a[i][visitV] == 0) {
                        a[i][visitV] = roundCount;
                        a[visitV][i] = roundCount;
                    }
//                    System.out.println("방문할 연결노드 : "+visitV);
                    if (visited[visitV] == false) {
                        visited[visitV] = true;
                        ArrayList<Integer> visitVList = arr.get(visitV);
                        for (int j = 0; j < visitVList.size(); j++) { // 다음 라운드 때 방문 할 노드 찾기
                            if (visited[visitVList.get(j)] == false) {
                                q.add(visitVList.get(j));
                            }
                        }
                    }
                }
            }
            answer[i] = roundCount;
//            System.out.println("================");
        }
        int min = Integer.MAX_VALUE;
        int minV = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += a[i][j];
            }
            if (sum < min) {
                min = sum;
                minV = i;
            }
        }
        System.out.println(minV);
    }
}
