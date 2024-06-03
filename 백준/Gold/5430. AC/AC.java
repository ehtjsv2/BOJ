import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static final boolean N = true;
    static final boolean R = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            String s = br.readLine().replaceAll("\\[", "")
                    .replaceAll("\\]", "");

            if (!s.equals("")) {
                numbers = Arrays.stream(s.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }

            boolean errorFlag = false;
            Deque<Integer> naturalQ = new LinkedList<>(numbers);
            boolean nowQ = N;
            for (int j = 0; j < command.length(); j++) {
                if (errorFlag == true) {
                    break;
                }
                char nowCommand = command.charAt(j);
                if (nowCommand == 'R') {
                    nowQ = !nowQ;
                }
                if (nowCommand == 'D') {
                    if (nowQ == N) {
                        if (naturalQ.pollFirst() == null) {
                            errorFlag = true;
                        }
                    } else {
                        if (naturalQ.pollLast() == null) {
                            errorFlag = true;
                        }
                    }
                }
            }

            if (errorFlag) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (nowQ == N) {
                    sb.append(naturalQ.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
                } else {
                    List<Integer> list = naturalQ.stream().collect(Collectors.toList());
                    List<Integer> reverseList = new ArrayList<>();
                    for (int j = list.size() - 1; j >= 0; j--) {
                        reverseList.add(list.get(j));
                    }
                    sb.append(reverseList.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}

