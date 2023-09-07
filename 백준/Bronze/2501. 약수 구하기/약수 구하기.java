import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=(N/2);i++){
            if(N%i==0)list.add(i);
        }
        list.add(N);
        if(list.size()<K)System.out.println(0);
        else System.out.println(list.get(K-1));
    }
}
