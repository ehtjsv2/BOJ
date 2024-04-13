import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Balloon {
    int order;
    int value;

    Balloon(int order, int value) {
        this.order = order;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            balloons.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (balloons.size() == 1) {
                sb.append(balloons.pop().order);
                break;
            }
            Balloon balloon = balloons.pop();
            int nowPaperNumber = balloon.value;
            int nowOrderNumber = balloon.order;
            sb.append(nowOrderNumber + " ");
            // 양수
            if (nowPaperNumber > 0) {
                for (int j = 0; j < nowPaperNumber - 1; j++) {
                    balloons.addLast(balloons.pop());
                }
            } else {//음수
                for (int j = 0; j > nowPaperNumber; j--) {
                    balloons.addFirst(balloons.removeLast());
                }
            }
        }
        System.out.println(sb.toString());
    }
}

