import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            } else if (command.equals("check")) {
                if (set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (!set.remove(num)) {
                    set.add(num);
                }
            } else if (command.equals("all")) {
                set = new HashSet<>();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
