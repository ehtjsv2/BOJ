import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a < 0)
                break;
            list.add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            int N = list.get(i);

            for (int j = 1; j <= (N / 2); j++) {
                if (N % j == 0) {
                    sum += j;
                    if (j * 2 == N)
                        sb.append(j);
                    else
                        sb.append(j + " + ");
                }
            }

            if (N == sum) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sum + " = ");
                sb2.append(sb.toString());
                System.out.println(sb2.toString());
            } else
                System.out.println(N + " is NOT perfect.");
        }
    }
}