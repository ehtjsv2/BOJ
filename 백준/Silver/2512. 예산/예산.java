import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Long> moneys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long money = Long.parseLong(st.nextToken());
            if (money > max) {
                max = money;
            }
            moneys.add(money);
        }
        long M = Long.parseLong(br.readLine());

        long low = 0;
        long high = max+1;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long sum = sum(mid);
            if (sum > M) {
                high = mid;
            }
            else{
                low = mid;
            }
        }

        System.out.println(low);
    }

    static long sum(long mid) {
        long sum = 0;
        for (Long money : moneys) {
            if (money < mid) {
                sum += money;
            } else {
                sum += mid;
            }
        }
        return sum;
    }
}
