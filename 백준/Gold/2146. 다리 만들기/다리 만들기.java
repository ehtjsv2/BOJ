import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] number;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        number = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        int numberCount = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && number[i][j] == 0) {
                    dfs(i, j, numberCount++);
                }
            }
        }

        visited = new boolean[N][N];
        ArrayDeque<Node> dq = new ArrayDeque<>();
        ArrayDeque<Node> dq2 = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    dq.addLast(new Node(i, j, number[i][j]));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        boolean flag = true;
        int depth = 1;
        int[][] depths = new int[N][N];
        while (!dq.isEmpty() || !dq2.isEmpty()) {
            Node now = flag ? dq.removeFirst() : dq2.removeFirst();
//            System.out.printf("depth = %d, now: %d,%d\n",depth,now.i,now.j);
            for (int i = 0; i < 4; i++) {
                int nextI = now.i + dx[i];
                int nextJ = now.j + dy[i];
                if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N) {
                    continue;
                }

                if (arr[nextI][nextJ] == 0 && visited[nextI][nextJ] == false) {
                    visited[nextI][nextJ] = true;
                    number[nextI][nextJ] = now.number;
                    depths[nextI][nextJ] = depth;
                    if (flag == true) {
                        dq2.addLast(new Node(nextI, nextJ, now.number));
                    } else {
                        dq.addLast(new Node(nextI, nextJ, now.number));
                    }
                } else if (arr[nextI][nextJ] == 0 && visited[nextI][nextJ] == true
                        && number[nextI][nextJ] != now.number) {
//                    System.out.printf("%d,%d next: %d%d\n",now.i,now.j,nextI,nextJ);
                    if (depths[nextI][nextJ]!=depth) {
                        int can = depth * 2 - 2;
                        answer = Math.min(answer, can);
                    } else {
                        int can = depth * 2 - 1;
                        answer = Math.min(answer, can);
                    }
                }
            }

            if (flag == true && dq.isEmpty()) {
                flag = !flag;
                depth++;
                if(answer!=Integer.MAX_VALUE){
                    break;
                }
            } else if (flag == false && dq2.isEmpty()) {
                flag = !flag;
                depth++;
                if(answer!=Integer.MAX_VALUE){
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int i, int j, int count) {
        visited[i][j] = true;
        number[i][j] = count;
        for (int k = 0; k < 4; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];
            if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N) {
                continue;
            }
            if (arr[nextI][nextJ] == 1 && visited[nextI][nextJ] == false) {
                dfs(nextI, nextJ, count);
            }
        }
    }

    static class Node {
        int i;
        int j;
        int number;

        public Node(int i, int j, int number) {
            this.i = i;
            this.j = j;
            this.number = number;
        }
    }
}
