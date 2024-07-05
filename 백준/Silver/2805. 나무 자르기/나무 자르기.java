import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Long> trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new ArrayList<>();
        long max = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            if (num > max) {
                max = num + 1;
            }
            trees.add(num);
        }

        long high = max;
        long low = 0;
        while (low + 1 < high) {
            long mid = (high + low) / 2;
            long count = count(mid);
            if (count < M) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(low);
    }

    static long count(long value) {
        long count = 0;
        for (Long tree : trees) {
            if (tree - value > 0) {
                count += tree - value;
            }
        }
        return count;
    }
}
