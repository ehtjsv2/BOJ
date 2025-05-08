import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] garoDi = {0, 1};
    static int[] garoDj = {1, 1};
    static int[] seroDi = {1, 1};
    static int[] seroDj = {0, 1};
    static int[] degaDi = {0, 1, 1};
    static int[] degaDj = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0, 1, 0, 0));
        int answer = 0;
        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            if (now.i == N - 1 && now.j == N - 1) {
                answer++;
                continue;
            }
            int nextI;
            int nextJ;
            int nextI2 = now.i;
            int nextJ2 = now.j;
            if (now.i - now.i2 == 1 && now.j - now.j2 == 1) {// 대각
                for (int i = 0; i < 3; i++) {
                    nextI = now.i + degaDi[i];
                    nextJ = now.j + degaDj[i];
                    if (nextI < N && nextJ < N && arr[nextI][nextJ] != 1 && arr[nextI2][nextJ] !=1 && arr[nextI][nextJ2] != 1) {
                        dq.addLast(new Node(nextI, nextJ, nextI2, nextJ2));
                    }
                }
            } else if (now.j - now.j2 == 1) { // 가로
                for (int i = 0; i < 2; i++) {
                    nextI = now.i + garoDi[i];
                    nextJ = now.j + garoDj[i];
                    if (nextI < N && nextJ < N && arr[nextI][nextJ] != 1 && arr[nextI2][nextJ] !=1 && arr[nextI][nextJ2] != 1) {
                        dq.addLast(new Node(nextI, nextJ, nextI2, nextJ2));
                    }
                }
            } else if (now.i - now.i2 == 1) { // 세로
                for (int i = 0; i < 2; i++) {
                    nextI = now.i + seroDi[i];
                    nextJ = now.j + seroDj[i];
                    if (nextI < N && nextJ < N && arr[nextI][nextJ] != 1 && arr[nextI2][nextJ] !=1 && arr[nextI][nextJ2] != 1) {
                        dq.addLast(new Node(nextI, nextJ, nextI2, nextJ2));
                    }
                }
            } else {
                System.out.println("에러");
            }


        }

        System.out.println(answer);
    }

    static class Node {
        int i;
        int j;
        int i2;
        int j2;

        public Node(int i, int j, int i2, int j2) {
            this.i = i;
            this.j = j;
            this.i2 = i2;
            this.j2 = j2;
        }
    }
}
