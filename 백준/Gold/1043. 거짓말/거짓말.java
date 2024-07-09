import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[N + 1][N + 1];
        boolean[] know = new boolean[N + 1];
        String[] parties = new String[M];

        st = new StringTokenizer(br.readLine());
        int knowIndex = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowIndex; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            graph[i][i] = true;
        }

        for (int i = 0; i < M; i++) {
            String party = br.readLine();
            parties[i] = party;
            st = new StringTokenizer(party);
            int c = Integer.parseInt(st.nextToken());
            int before = -1;
            if (c >= 2) {
                before = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < c - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph[before][next] = true;
                graph[next][before] = true;
                before = next;
            }
        }
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        int answer = 0;
        for (int i = 0; i < parties.length; i++) {
//            System.out.println(i + "번째 파티");
            int cnt = Integer.parseInt(parties[i].substring(0, 2).trim());
//            System.out.println(cnt);
            String party = parties[i].substring(2);
//            System.out.println(party);
            st = new StringTokenizer(party);
            boolean isFindAnswer = false;
            for (int j = 0; j < cnt; j++) {
                if (isFindAnswer == true) {
                    break;
                }
                Stack<Integer> stack = new Stack<>();
                boolean[] visited = new boolean[N + 1];
                int visit = Integer.parseInt(st.nextToken());
                stack.push(visit);
                visited[visit] = true;
                if (know[visit] == true) {
//                    System.out.println("진실아는 자 발견 = " + visit);
                    answer--;
                    isFindAnswer = true;
                }
                while (!stack.isEmpty() && isFindAnswer == false) {
                    int now = stack.pop();
                    for (int k = 1; k < N + 1; k++) {
                        if (graph[now][k] == true && visited[k] == false) {
//                            System.out.println("확인할 = " + visit + ", 연결된 = " + k);
                            if (know[k] == true) {
//                                System.out.println("진실아는 자 발견 = " + k);
                                answer--;
                                isFindAnswer = true;
                                break;
                            }
                            stack.push(k);
                            visited[k] = true;
                        }
                    }
                }
            }
        }

        System.out.println(parties.length + answer);
    }
}
