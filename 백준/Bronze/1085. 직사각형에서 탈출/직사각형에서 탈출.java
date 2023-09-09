import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int xw = w-x;
        int yh = y-h;
        int answer=(Math.abs(xw)>=Math.abs(yh))?Math.abs(yh):Math.abs(xw);
        answer = (answer>=x)?x:answer;
        answer = (answer>=y)?y:answer;
        System.out.println(answer);
    }
}
