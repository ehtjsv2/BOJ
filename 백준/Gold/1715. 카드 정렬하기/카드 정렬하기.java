import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.add(Long.parseLong(br.readLine()));
        }

        if(q.size() == 1){
            System.out.println(0);
            return;
        }

        long answer = 0;
        while (q.size() > 1) {
            long num1 = q.poll();
            long num2 = q.poll();
            long sum = num1 + num2;
            answer+=sum;
            q.add(sum);
        }

        System.out.println(answer);
    }
}
