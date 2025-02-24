import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int[][] arr;
    static List<Position> chickenPositions = new ArrayList<>();
    static List<Position> houses = new ArrayList<>();
    static int minDistanceSum = Integer.MAX_VALUE;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    houses.add(new Position(i, j));
                }
                if (arr[i][j] == 2) {
                    chickenPositions.add(new Position(i, j));
                }
            }
        }

        ArrayList<Integer> visitChicken = new ArrayList<>();
        for (int i = 0; i < chickenPositions.size(); i++) {
            visitChicken.add(i);
            bt(1, visitChicken, i);
            visitChicken.remove(visitChicken.size() - 1);
        }

        System.out.println(minDistanceSum);
    }

    public static void bt(int depth, List<Integer> visitChicken, int visitIndex) {
        if (depth >= M) {
            int sum = 0;
            for (Position house : houses) {
                int houseDistance = Integer.MAX_VALUE;
                for (int i : visitChicken) {
                    Position chicken = chickenPositions.get(i);
                    houseDistance = Math.min(Math.abs(chicken.y - house.y) + Math.abs(chicken.x - house.x), houseDistance);
                }
                sum+=houseDistance;
            }
            minDistanceSum = Math.min(minDistanceSum, sum);
            return;
        }

        for (int i = visitIndex + 1; i < chickenPositions.size(); i++) {
            visitChicken.add(i);
            bt(depth + 1, visitChicken, i);
            visitChicken.remove(visitChicken.size() - 1);
        }
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
