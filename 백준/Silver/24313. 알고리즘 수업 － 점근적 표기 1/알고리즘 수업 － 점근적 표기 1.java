import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(fx(a1,a2,n)<=gx(c,n)&&a1<=c)System.out.println(1);
        else System.out.println(0);
    }

    public static int fx(int a1, int a2, int i){
        return a1*i+a2;
    }

    public static int gx(int c,int i){
        return c*i;
    }

}
