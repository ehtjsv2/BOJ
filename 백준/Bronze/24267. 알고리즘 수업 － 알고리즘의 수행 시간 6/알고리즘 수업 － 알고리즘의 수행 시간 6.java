import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long sum = 0L;
        Long N = Long.parseLong(br.readLine());
        for(int i=1;i<=N-2;i++){
            sum+= i*((N-1)-i);
        }
        System.out.println(sum+"\n"+3);
    }

}