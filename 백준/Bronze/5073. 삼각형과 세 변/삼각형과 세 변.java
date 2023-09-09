import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a + b + c == 0)
                break;

            int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);

            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else {
                if (2 * max - (a + b + c) >= 0) {
                    System.out.println("Invalid");
                }
                else if (a != b && b != c && a != c)
                    System.out.println("Scalene");
                else
                    System.out.println("Isosceles");
            }
        }

    }
}