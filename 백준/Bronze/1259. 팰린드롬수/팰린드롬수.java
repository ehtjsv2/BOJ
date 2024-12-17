import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            String answer = "yes";
            for (int i = 0; i <= (num.length() - 1) / 2; i++) {
                if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}