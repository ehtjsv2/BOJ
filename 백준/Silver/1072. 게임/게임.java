import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = 100 * y / x;
        if (z == 100 || z == 99) {
            System.out.println(-1);
            return;
        }

        long y2 = y + 1;
        long x2 = x + 1;
        long count = 2;
        long beforeY2 = y;
        long beforeX2 = x;
        long z2 = 100 * y2 / x2;
        while (z == z2) {
            beforeY2 = y2;
            beforeX2 = x2;
            y2 += count;
            x2 += count;
            count*=2;
            z2 = 100 * y2 / x2;
        }

        long left = beforeY2 - y;
        long right = y2 - y;
        long middle = (right + left) / 2;
        while (left < right) {
            middle = (right + left) / 2;
            x2 = x + middle;
            y2 = y + middle;
            z2 = 100 * y2 / x2;
            if (z2 == z) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        System.out.println(left);
    }
}
