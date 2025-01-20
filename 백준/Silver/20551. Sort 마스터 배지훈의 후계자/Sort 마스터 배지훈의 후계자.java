import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int want = Integer.parseInt(br.readLine());
            int l = 0;
            int r = N - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (arr[m] < want) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (arr[l] != want) {
                sb.append(-1).append("\n");
            } else {
                sb.append(l).append("\n");
            }
        }

        System.out.println(sb);
    }
}
