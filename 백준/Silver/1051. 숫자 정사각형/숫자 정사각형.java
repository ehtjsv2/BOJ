import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = a.charAt(j) - '0';
            }
        }

        int answer = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = arr[i][j];
                for (int k = 1; k < M; k++) {
                    if (i + k >= N || j + k >= M) {
                        break;
                    }
                    if (arr[i + k][j] == num && arr[i][j + k] == num && arr[i + k][j + k] == num) {
                        if ((k + 1) * (k + 1) > answer) {
                            answer = (k + 1) * (k + 1);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
