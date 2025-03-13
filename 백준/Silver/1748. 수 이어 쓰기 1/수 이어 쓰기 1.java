import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int digit = findDigit(N);

        long answer = 0;
        for (int i = 1; i < digit; i++) {
            answer += 9 * (int) Math.pow(10, i - 1) * i;
        }
        answer += (N - Math.pow(10, digit-1) + 1) * digit;
        System.out.println(answer);
    }

    public static int findDigit(int num) {
        int digit = 0;
        while (num > 0) {
            digit++;
            num = num / 10;
        }
        return digit;
    }
}
