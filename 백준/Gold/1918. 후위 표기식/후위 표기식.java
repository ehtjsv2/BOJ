import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> nota = new ArrayDeque<>();
        String exp = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                nota.addFirst(ch);
            } else if (ch == ')') {
                while (!nota.isEmpty() && nota.peekFirst() != '(') {
                    sb.append(nota.removeFirst());
                }
                if(!nota.isEmpty() && nota.peekFirst() == '('){
                    nota.removeFirst();
                }
            } else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                while (!nota.isEmpty() && nota.peekFirst() != '(' && !isHighPriority(ch, nota.peekFirst())) {
                    sb.append(nota.removeFirst());
                }
                nota.addFirst(ch);
            } else {
                sb.append(ch);
            }
        }
        while(!nota.isEmpty()){
            sb.append(nota.removeFirst());
        }
        System.out.println(sb);
    }

    private static boolean isHighPriority(char ch, char compareCh) {
        if (ch == '(') {
            if (compareCh == '(') {
                return false;
            }
            return true;
        }
        if ((ch == '/' || ch == '*') && (compareCh == '+' || compareCh == '-')) {
            return true;
        }
        return false;
    }
}
