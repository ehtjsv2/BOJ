import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = getPercent(X, Y);

        int ans = -1;
        int low = 0;
        int high = X + 1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int Z2 = getPercent((X + mid), (Y + mid));
            if (Z2 > Z) {
                ans = mid;
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(ans);
    }


    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
