
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("2")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
            } else if (command.equals("3")) {
                sb.append(stack.size() + "\n");
            } else if (command.equals("4")) {
                if (stack.isEmpty()) {
                    sb.append("1" + "\n");
                } else {
                    sb.append("0" + "\n");
                }
            } else {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }

        System.out.print(sb.toString());

    }
}
