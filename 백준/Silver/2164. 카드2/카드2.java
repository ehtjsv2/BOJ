import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deck  = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deck.addLast(i);
        }

        while(deck.size()!=1){
            deck.removeFirst();
            int num = deck.pollFirst();
            deck.addLast(num);
        }

        System.out.println(deck.poll());
    }
}
