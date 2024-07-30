import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int di[] = {1, 0, -1, 0};
    static int dj[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        List<Location> virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                arr[i][j] = number;
                if (number == 2) {
                    virus.add(new Location(i, j));
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1번째 벽
                if (arr[i][j] == 2 || arr[i][j] == 1) {
                    continue;
                }
                int aNum = i * M + j;
                // 2번째 벽
                int bNum = aNum;
                while (bNum < M * N - 1) {
                    bNum++;
                    if (arr[bNum / M][bNum % M] == 2 || arr[bNum / M][bNum % M] == 1) {
                        continue;
                    }
                    // 3번째 벽
                    int cNum = bNum;
                    while (cNum < M * N - 1) {
                        cNum++;
                        if (arr[cNum / M][cNum % M] == 2 || arr[cNum / M][cNum % M] == 1) {
                            continue;
                        }
                        int[][] arr2 = new int[N][M];
                        for (int k = 0; k < N; k++) {
                            for (int l = 0; l < M; l++) {
                                arr2[k][l] = arr[k][l];
                            }
                        }
                        // bfs시작
                        int aI = aNum / M;
                        int aJ = aNum % M;
                        int bI = bNum / M;
                        int bJ = bNum % M;
                        int cI = cNum / M;
                        int cJ = cNum % M;
                        arr2[aI][aJ] = 1;
                        arr2[bI][bJ] = 1;
                        arr2[cI][cJ] = 1;
                        for (int k = 0; k < virus.size(); k++) {
                            Queue<Location> q = new ArrayDeque<>();
                            boolean[][] visited = new boolean[N][M];
                            Location visit = virus.get(k);
                            visited[visit.i][visit.j] = true;
                            q.add(visit);
                            while (!q.isEmpty()) {
                                Location now = q.poll();
                                int nowI = now.i;
                                int nowJ = now.j;
                                for (int l = 0; l < 4; l++) {
                                    int nextI = nowI + di[l];
                                    int nextJ = nowJ + dj[l];
                                    if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M) {
                                        continue;
                                    }
                                    if (visited[nextI][nextJ] == false && arr2[nextI][nextJ] == 0) {
                                        arr2[nextI][nextJ] = 2;
                                        visited[nextI][nextJ] = true;
                                        q.add(new Location(nextI, nextJ));
                                    }
                                }
                            }
                        }
                        int countSafeZone = 0;
                        for (int k = 0; k < N; k++) {
                            for (int l = 0; l < M; l++) {
                                if (arr2[k][l] == 0) {
                                    countSafeZone++;
                                }
                            }
                        }
                        if (countSafeZone > max) {
                            max = countSafeZone;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    static class Location {
        int i;
        int j;

        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
