import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            if (list.get(0) == 0) {
                break;
            }

            list.sort(Comparator.naturalOrder());

            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            if (a * a + b * b == c * c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
