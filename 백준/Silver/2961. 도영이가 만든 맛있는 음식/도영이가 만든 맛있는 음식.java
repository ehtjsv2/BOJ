import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            func(1, 0, i);
        }

        System.out.println(answer);
    }

    private static void func(int a, int b, int visit) {
        int visitA = arr[visit][0];
        int visitB = arr[visit][1];
        a *= visitA;
        b += visitB;
        int sum = Math.abs(a - b);
        if (answer > sum) {
            answer = sum;
        }
        for (int i = visit + 1; i < N; i++) {
            func(a, b, i);
        }
    }
}
