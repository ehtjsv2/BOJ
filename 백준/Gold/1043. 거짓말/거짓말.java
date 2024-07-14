import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        node = new Integer[N + 1];
        boolean[] know = new boolean[N+1];
        String[] parties = new String[M];

        st = new StringTokenizer(br.readLine());
        int knowIndex = Integer.parseInt(st.nextToken());
        // 진실 아는 사람
        for (int i = 0; i < knowIndex; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        // 각 노드 부모 본인으로 초기화
        for (int i = 1; i < N + 1; i++) {
            node[i] = i;
        }

        // 파티 순회하며 부모 업데이트
        for (int i = 0; i < M; i++) {
            String party = br.readLine();
            parties[i] = party;
            st = new StringTokenizer(party);
            int c = Integer.parseInt(st.nextToken());
            int before = -1;
            if (c >= 2) {
                before = Integer.parseInt(st.nextToken());
            }
            // n번 째 파티
            for (int j = 0; j < c - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                union(before,next);
                before = next;
            }
        }


        for (int i = 1; i <= N; i++) {
            if(know[i]){
                know[findParent(i)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(parties[i]);
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (know[findParent(num)]){
                    answer++;
                    break;
                }
            }
        }

        System.out.println(M-answer);

    }

    static int findParent(int num) {
        if (node[num] == num) {
            return num;
        }
        return findParent(node[num]);
    }

    static void union(int x, int y){
        int xParent = findParent(x);
        int yParent = findParent(y);

        if(xParent<yParent){
            node[yParent] = xParent;
        }
        else if(yParent<xParent){
            node[xParent] = yParent;
        }
    }
}
