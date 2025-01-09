import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Deque<Character> q = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            q.addFirst(input.charAt(i));
        }

        while (!q.isEmpty()) {
            char now = q.removeLast();
            if (now == 'A') {
                if (q.isEmpty() || q.peekLast() == 'A' || stack.size() < 2) {
                    System.out.println("NP");
                    return;
                }
                q.removeLast();
                stack.pop();
                stack.pop();
                stack.push('P');
            }
            else{
                stack.push(now);
            }

        }
        if(stack.size() != 1){
            System.out.println("NP");
        }
        else{
            System.out.println("PPAP");
        }
    }
}
