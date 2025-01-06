import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum+=num;
            dq.addLast(num);
            while(!dq.isEmpty() && sum>M){
                sum-= dq.removeFirst();
            }
            if(sum==M){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
