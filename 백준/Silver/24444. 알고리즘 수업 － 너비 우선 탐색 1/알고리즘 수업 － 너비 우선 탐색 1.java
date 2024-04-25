
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5 5 1
1 4
1 2
2 3
2 4
3 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
//        int[][] arr = new int[N + 1][N + 1];
        List<List<Integer>> arr = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        int order[] = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
            arr.get(e).add(s);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        Queue<Integer> queue = new ArrayDeque<>();
        visited[R] = true;
        queue.add(R);
        int orderNumber = 1;
        order[R] = orderNumber++;
        while (!queue.isEmpty()) {
            int visit = queue.poll();
            for (int i : arr.get(visit)) {
                if (visited[i] == false) {
                    visited[i] = true;
                    order[i] = orderNumber++;
                    queue.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i] + "\n");
        }

        System.out.println(sb);
    }
}
