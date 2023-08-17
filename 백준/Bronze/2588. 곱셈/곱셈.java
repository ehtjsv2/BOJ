import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int thrid = A*(B%10);
        int fourth = A*((B%100)/10);
        int fifth = A*(B/100);
        System.out.println(thrid);
        System.out.println(fourth);
        System.out.println(fifth);
        System.out.println(A*B);
 
    }
}