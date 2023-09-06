import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int diff = A-B;
        int VdivideDiff=V/diff;
        int AdivideDiff=A/diff+1;
        int cnt = VdivideDiff-AdivideDiff;
        //System.out.println(VdivideDiff+" "+AdivideDiff+" "+divideDiff);
        int start = A*cnt - B*cnt;
        while(true){
            cnt++;
            start = start+A;
            if(start>=V)break;
            start = start-B;
        }
        System.out.println(cnt);
    }
}