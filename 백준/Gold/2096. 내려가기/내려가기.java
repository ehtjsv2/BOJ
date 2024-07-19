import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] num = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minDp[0][0] = num[0][0];
        minDp[0][1] = num[0][1];
        minDp[0][2] = num[0][2];

        maxDp[0][0] = num[0][0];
        maxDp[0][1] = num[0][1];
        maxDp[0][2] = num[0][2];

        for (int i = 1; i < N; i++) {
            //max
            for (int j = 0; j < 3; j++) {
                int max = -1;
                int min = Integer.MAX_VALUE;
                int nowNum = num[i][j];
                for (int k = 0; k < 3; k++) {
                    int beforeIndex = j + dx[k];
                    if (beforeIndex < 0 || beforeIndex > 2) {
                        continue;
                    }
                    int beforeMaxDp = maxDp[i - 1][beforeIndex];
                    int beforeMinDp = minDp[i - 1][beforeIndex];
                    if (beforeMaxDp > max) {
                        max = beforeMaxDp;
                    }
                    if (beforeMinDp < min) {
                        min = beforeMinDp;
                    }
                }
                maxDp[i][j] = nowNum + max;
                minDp[i][j] = nowNum + min;
            }
        }
        
        int max = Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2]));
        int min = Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2]));
        System.out.println(max + " " + min);
    }
}
