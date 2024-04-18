import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = 0;
        String[] split = str.split("-");

        int sum = Arrays.stream(split[0].split("\\+")).mapToInt(Integer::parseInt).sum();
        for (int i = 1; i < split.length; i++) {
            sum -= Arrays.stream(split[i].split("\\+")).mapToInt(Integer::parseInt).sum();
        }
        System.out.println(sum);
    }
}
