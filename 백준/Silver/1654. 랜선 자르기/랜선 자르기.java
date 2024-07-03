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
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        trees = new ArrayList<>();
        long max = 0;
        for (int i = 0; i < K; i++) {
            long num = Long.parseLong(br.readLine());
            if (num > max) {
                max = num;
            }
            trees.add(num);
        }

        long count = trees.size();
        long high = max+1;
        long low = 0;

        while (low < high-1) {
            long middle = (high + low) / 2;
            count = count(middle);
            if (count >= N) {
                low = middle;
            } else {
                high = middle;
            }
        }

        System.out.println(low);
    }

    static long count(long value) {
        long answer = 0;
        for (Long tree : trees) {
            answer += tree / value;
        }
        return answer;
    }
}
