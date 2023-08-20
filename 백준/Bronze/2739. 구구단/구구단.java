import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=9;i++){
            System.out.println(N+" * "+i+" = "+N*i);
        }
    }
}