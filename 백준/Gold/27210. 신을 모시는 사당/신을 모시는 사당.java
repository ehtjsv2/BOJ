import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int NULL = 100_100;

    static int N;
    static int[] list;
    static int[] dpL1;
    static int[] dpL2;
    static int[] dpR1;
    static int[] dpR2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        dpL1 = new int[N];
        dpL2 = new int[N];
        dpR1 = new int[N];
        dpR2 = new int[N];

        for (int i = 0; i < N; i++) {
            dpL1[i] = NULL;
            dpL2[i] = NULL;
            dpR1[i] = NULL;
            dpR2[i] = NULL;
            int num = Integer.parseInt(st.nextToken());
            if (num == 2) {
                list[i] = -1;
            } else {
                list[i] = 1;
            }
        }

        dpL1[0] = Math.max(list[0], 0);
        dpL2[0] = Math.min(list[0], 0);
        dpR1[N - 1] = Math.max(list[N - 1], 0);
        dpR2[N - 1] = Math.min(list[N - 1], 0);

        for (int i = 0; i < N; i++) {
            dpL1[i] = findDpL1(i);
            dpL2[i] = findDpL2(i);
            dpR1[i] = findDpR1(i);
            dpR2[i] = findDpR2(i);
//            System.out.println("------------" + i + "----------");
//            System.out.println("L1 : " + dpL1[i]);
//            System.out.println("L2 : " + dpL2[i]);
//            System.out.println("R1 : " + dpR1[i]);
//            System.out.println("R2 : " + dpR2[i]);
        }

        int max = 0;
        int min = 0;
        for (int i = 0; i < N; i++) {
            // 1많은 것
            int leftDp1 = i - 1 >= 0 ? dpL1[i - 1] : 0;
            int rightDp1 = i + 1 < N ? dpR1[i + 1] : 0;
            int now1 = leftDp1 + rightDp1 + list[i];
            if (now1 > max) {
                max = now1;
            }

            // 2많은 것
            int leftDp2 = i - 1 >= 0 ? dpL2[i - 1] : 0;
            int rightDp2 = i + 1 < N ? dpR2[i + 1] : 0;
            int now2 = leftDp2 + rightDp2 + list[i];
            if (now2 < min) {
                min = now2;
            }
        }

        int answer = Math.max(max, Math.abs(min));
        System.out.println(answer);
    }

    static int findDpL1(int i) {
        if (i < 0) {
            return 0;
        }
        if (dpL1[i] != NULL) {
            return dpL1[i];
        }
        // 0보다 크면 무조건 이득
        // 음수일경우 안쓸 거나 마찬가지 -> 0로 해도됨
        if (findDpL1(i - 1) + list[i] > 0) {
            dpL1[i] = findDpL1(i - 1) + list[i];
        } else {
            dpL1[i] = 0;
        }
        return dpL1[i];
    }

    // 음수로 클수록 이득
    static int findDpL2(int i) {
        if (i < 0) {
            return 0;
        }
        if (dpL2[i] != NULL) {
            return dpL2[i];
        }
        // 0이상이면 안쓸 거나 마찬가지 -> 0로 해도됨
        // 음수면 무조건 이득
        if (findDpL2(i - 1) + list[i] < 0) {
            dpL2[i] = findDpL2(i - 1) + list[i];
        } else {
            dpL2[i] = 0;
        }
        return dpL2[i];
    }

    static int findDpR1(int i) {
        if (i >= N) {
            return 0;
        }
        if (dpR1[i] != NULL) {
            return dpR1[i];
        }
        // 0보다 크면 무조건 이득
        // 음수일경우 안쓸 거나 마찬가지 -> 0로 해도됨
        if (findDpR1(i + 1) + list[i] > 0) {
            dpR1[i] = findDpR1(i + 1) + list[i];
        } else {
            dpR1[i] = 0;
        }
        return dpR1[i];
    }

    static int findDpR2(int i) {
        if (i >= N) {
            return 0;
        }
        if (dpR2[i] != NULL) {
            return dpR2[i];
        }
        // 0이상이면 안쓸 거나 마찬가지 -> 0로 해도됨
        // 음수면 무조건 이득
        if (findDpR2(i + 1) + list[i] < 0) {
            dpR2[i] = findDpR2(i + 1) + list[i];
        } else {
            dpR2[i] = 0;
        }
        return dpR2[i];
    }
}
