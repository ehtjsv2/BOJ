import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String visit = br.readLine();
        st = new StringTokenizer(visit);
        StringTokenizer st2 = new StringTokenizer(visit);
        int max = 0;
        int count = 1;
        for (int i = 0; i < X; i++) {
            max += Integer.parseInt(st.nextToken());
        }

        int sum = max;
        for (int i = X; i < N; i++) {
            sum -= Integer.parseInt(st2.nextToken());
            sum += Integer.parseInt(st.nextToken());
            if (sum == max) {
                count++;
            } else if (sum > max) {
                count = 1;
                max = sum;
            }
        }

        if(max==0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max + "\n" + count);
        }
    }
}
