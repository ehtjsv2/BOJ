import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        PriorityQueue<Cost> costs = new PriorityQueue<>(
                (c1, c2) -> {
                    return c1.cost - c2.cost;
                }
        );
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            costs.add(new Cost(x, y, cost));
        }

        int answer = 0;
        while (!costs.isEmpty()) {
            Cost cost = costs.poll();
            if(union(cost.x, cost.y)){
                answer+=cost.cost;
            }
        }

        System.out.println(answer);
    }

    static class Cost {
        int x;
        int y;
        int cost;

        public Cost(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static public boolean union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if(x==y){
            return false;
        }

        if(x<=y){
            arr[y] = x;
        }else{
            arr[x] = y;
        }
        return true;
    }

    static public int findParent(int x) {
        if (arr[x] == x) {
            return x;
        }
        return findParent(arr[x]);
    }
}
