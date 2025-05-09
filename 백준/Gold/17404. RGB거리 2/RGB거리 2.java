import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 1000 * 1001;
    static int N;
    static int[][] arr;
    static int[] dpR;
    static int[] dpG;
    static int[] dpB;
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];
        dpR = new int[N + 1];
        dpG = new int[N + 1];
        dpB = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        // dpR[i] = arr[i][0]+Math.min(dpG[i+1],dpB[i+1]);

        // dpR구[0]할 때
        dpR[N] = MAX;
        dpG[N] = arr[N][G];
        dpB[N] = arr[N][B];
        int answer = findDp(1, R);

        // dpG 구할 때
        dpR = new int[N + 1];
        dpG = new int[N + 1];
        dpB = new int[N + 1];
        dpG[N] = MAX;
        dpR[N] = arr[N][R];
        dpB[N] = arr[N][B];
        answer = Math.min(answer,findDp(1,G));


        // dpB
        dpR = new int[N + 1];
        dpG = new int[N + 1];
        dpB = new int[N + 1];
        dpB[N] = MAX;
        dpR[N] = arr[N][R];
        dpG[N] = arr[N][G];
        answer = Math.min(answer,findDp(1,B));
        System.out.println(answer);
    }

    public static int findDp(int i, int callerColor) {
        if (i > N) {
            return 0;
        }
        if (callerColor == R) {
            if (dpR[i] != 0) {
                return dpR[i];
            }
            dpR[i] = arr[i][R]
                    + Math.min(findDp(i + 1, G), findDp(i + 1, B));
            return dpR[i];
        }
        if (callerColor == G) {
            if (dpG[i] != 0) {
                return dpG[i];
            }
            dpG[i] = arr[i][G]
                    + Math.min(findDp(i + 1, R), findDp(i + 1, B));
            return dpG[i];
        } else {
            if (dpB[i] != 0) {
                return dpB[i];
            }
            dpB[i] = arr[i][B]
                    + Math.min(findDp(i + 1, G), findDp(i + 1, R));
            return dpB[i];
        }
    }


}
