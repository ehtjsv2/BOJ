import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        int[] ingredients = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            ingredients[i] = num;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int want = M - ingredients[i];
            if (set.contains(want)) {
                answer++;
            }
        }

        System.out.println(answer/2);

    }
}
