import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> treeA = tree.get(a);
            List<Integer> treeB = tree.get(b);
            treeA.add(b);
            treeB.add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        visited[1] = true;
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            List<Integer> nowNode = tree.get(now);
            for (Integer visit : nowNode) {
                if (visited[visit] == false) {
                    visited[visit] = true;
                    q.add(visit);
                    parent[visit] = now;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }
}
