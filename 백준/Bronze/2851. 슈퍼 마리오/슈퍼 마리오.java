import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        sum += Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            int next = Integer.parseInt(br.readLine());
            if (Math.abs(sum + next - 100) <= Math.abs(sum-100)) {
                sum +=next;
            }
            else{
                break;
            }
        }
        System.out.println(sum);
    }
}