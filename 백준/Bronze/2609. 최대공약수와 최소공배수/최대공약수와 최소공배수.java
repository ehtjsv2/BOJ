import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Math.min(a, b);

        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }

        long a2 = a;
        long b2 = b;
        while (true) {
            if(a2==b2){
                System.out.println(a2);
                break;
            }
            if(a2>b2){
                b2+=b;
            }
            else{
                a2+=a;
            }
        }
    }
}