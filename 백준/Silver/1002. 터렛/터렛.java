import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[][] arr;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int wantDist1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int wantDist2 = Integer.parseInt(st.nextToken());

            double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

            if(d==0 && wantDist1 == wantDist2){
                System.out.println(-1);
            }
            else if(d > wantDist1+wantDist2 || d<Math.abs(wantDist1-wantDist2)){
                System.out.println(0);
            }
            else if(d == wantDist1+wantDist2 || d == Math.abs(wantDist1-wantDist2)){
                System.out.println(1);
            }
            else {
                System.out.println(2);
            }
        }
    }


    public static double calDist(int len1, int len2) {
        return Math.sqrt(Math.pow(len1, 2) + Math.pow(len2, 2));
    }
}
