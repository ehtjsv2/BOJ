import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = N % 10;
        int b = (N / 10 + a) % 10;
        int newNum = a * 10 + b;
        int answer = 1;
        while (newNum != N) {
            a = newNum % 10;
            b = (newNum / 10 + a) % 10;
            newNum = a * 10 + b;
            answer++;
        }
        System.out.println(answer);
    }
}
