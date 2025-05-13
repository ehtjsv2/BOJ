import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int S;
    static int answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(-1,0);

        System.out.println(answer);
    }

    public static void bt(int index, int sum) {
        if (index >= N) {
            return;
        }
        if(sum==S && index!=-1){
            answer++;
        }
        for (int i = index + 1; i < N; i++) {
            sum += arr[i];
            bt(i, sum);
            sum -= arr[i];
        }
    }
}
