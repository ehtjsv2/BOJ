import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                set.add(num);
            }

            list.sort(Comparator.naturalOrder());

            int answer = 0;
            for (int i = 0; i < N - 1; i++) {
                int num = list.get(i);
                for (int j = i + 1; j < N; j++) {
                    int nextNum = list.get(j);
                    int expectedNextNextNum = nextNum + (nextNum - num);
                    if (set.contains(expectedNextNextNum)){
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
