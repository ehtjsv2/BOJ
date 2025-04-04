import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        List<PriorityQueue<Integer>> v = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            v.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            v.get(v1).add(v2);
            v.get(v2).add(v1);
        }

        int[] answer = new int[N+1];
        int order = 1;
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            answer[now] = order++;

            PriorityQueue<Integer> nextVisit = v.get(now);
            while(!nextVisit.isEmpty()){
                int next = nextVisit.poll();
                if(visit[next] == false){
                    q.add(next);
                    visit[next] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

}
