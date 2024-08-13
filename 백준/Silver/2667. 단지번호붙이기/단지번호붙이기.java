
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class Main {
    
    static int[][] arr;
    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> count = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    total++;
                    int privateCount = 1;
                    Deque<Position> q = new ArrayDeque<>();
                    q.add(new Position(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Position visit = q.poll();
                        int vi = visit.i;
                        int vj = visit.j;
                        for (int k = 0; k < 4; k++) {
                            int nextI = vi + di[k];
                            int nextJ = vj + dj[k];
                            if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N
                                    || visited[nextI][nextJ] == true || arr[nextI][nextJ] == 0) {
                                continue;
                            }
                            privateCount++;
                            q.add(new Position(nextI, nextJ));
                            visited[nextI][nextJ] = true;
                        }
                    }
                    count.add(privateCount);
                } else {
                    visited[i][j] = true;
                }
            }
        }
        count.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(total);
        for (int i = 0; i < count.size(); i++) {
            System.out.println(count.get(i));
        }
    }

    static class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
