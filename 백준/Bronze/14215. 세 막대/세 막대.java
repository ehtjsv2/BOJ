import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] x = new int[3];
        for (int i = 0; i < 3; i++)
            x[i] = Integer.parseInt(st.nextToken());

        int max = x[0] > x[1] ? (x[0] > x[2] ? 0 : 2) : (x[1] > x[2] ? 1 : 2);

        while (true) {
            if (x[0] == x[1] && x[1] == x[2]) {
                System.out.println(x[0] + x[1] + x[2]);
                break;
            } else {
                if (2 * x[max] - (x[0] + x[1] + x[2]) >= 0) {
                    x[max]--;
                    max = x[0] > x[1] ? (x[0] > x[2] ? 0 : 2) : (x[1] > x[2] ? 1 : 2);
                } else if (x[0] != x[1] && x[1] != x[2] && x[0] != x[2]) {
                    System.out.println(x[0] + x[1] + x[2]);
                    break;
                }
                else {
                    System.out.println(x[0] + x[1] + x[2]);
                    break;
                }
            }
        }

    }

}