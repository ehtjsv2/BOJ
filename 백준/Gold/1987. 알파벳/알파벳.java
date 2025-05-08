import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static int N;
    static int M;
    static char[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        HashSet<Character> set = new HashSet<>();
        set.add(arr[0][0]);
        boolean[] visitedAlpha = new boolean[30];
        visitedAlpha[arr[0][0]-'A'] = true;
        dfs(0,0,visitedAlpha,1);
        System.out.println(answer);
    }

    public static void dfs(int i, int j, boolean[] visitedAlpha, int depth) {
        if (answer < depth) {
            answer = depth;
        }
        for (int k = 0; k < 4; k++) {
            int nextI = i+di[k];
            int nextJ = j+dj[k];
            if (nextI >= N || nextJ >= M || nextJ < 0 || nextI < 0 || visitedAlpha[arr[nextI][nextJ]-'A']) {
                continue;
            }
            visitedAlpha[arr[nextI][nextJ] - 'A'] = true;
            dfs(nextI, nextJ, visitedAlpha, depth + 1);
            visitedAlpha[arr[nextI][nextJ] - 'A'] = false;
        }
    }
}
