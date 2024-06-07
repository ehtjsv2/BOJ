import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> bigQ = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Long> smallQ = new PriorityQueue<>();
            Map<Long, Integer> shouldRemoveBigQ = new HashMap<>();
            Map<Long, Integer> shouldRemoveSmallQ = new HashMap<>();
            int indexCount = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                long num = Long.parseLong(st.nextToken());
                if (command.equals("I")) {
                    indexCount++;
                    bigQ.add(num);
                    smallQ.add(num);
                } else {
                    if (num == 1) {
                        Long pollNum;
                        //poll한 숫자가 bigQ가 지워야할 숫자였다면 다시 poll
                        while (true) {
                            pollNum = bigQ.poll();
                            if (pollNum == null || shouldRemoveBigQ.get(pollNum) == null
                                    || shouldRemoveBigQ.get(pollNum) == 0) {
                                break;
                            } else {
                                shouldRemoveBigQ.replace(pollNum, shouldRemoveBigQ.get(pollNum) - 1);
                            }
                        }
                        if (pollNum != null) {
                            //smallQ가 지워야할 숫자로 넣어줌
                            indexCount--;
                            shouldRemoveSmallQ.put(pollNum, shouldRemoveSmallQ.getOrDefault(pollNum, 0) + 1);
                        }
                    } else {
                        Long pollNum;
                        while (true) {
                            pollNum = smallQ.poll();
                            if (pollNum == null || shouldRemoveSmallQ.get(pollNum) == null
                                    || shouldRemoveSmallQ.get(pollNum) == 0) {
                                break;
                            } else {
                                shouldRemoveSmallQ.replace(pollNum, shouldRemoveSmallQ.get(pollNum) - 1);
                            }
                        }
                        if (pollNum != null) {
                            indexCount--;
                            shouldRemoveBigQ.put(pollNum, shouldRemoveBigQ.getOrDefault(pollNum, 0) + 1);
                        }
                    }
                }

            }
            while (bigQ.peek() != null && shouldRemoveBigQ.get(bigQ.peek()) != null
                    && shouldRemoveBigQ.get(bigQ.peek()) > 0) {
                shouldRemoveBigQ.replace(bigQ.peek(),shouldRemoveBigQ.get(bigQ.peek())-1);
                bigQ.poll();
            }
            while (smallQ.peek() != null && shouldRemoveSmallQ.get(smallQ.peek()) != null
                    && shouldRemoveSmallQ.get(smallQ.peek()) > 0) {
                shouldRemoveSmallQ.replace(smallQ.peek(),shouldRemoveSmallQ.get(smallQ.peek())-1);
                smallQ.poll();

            }
            if (indexCount == 0 ) {
                System.out.println("EMPTY");
            } else {
                System.out.println(bigQ.poll() + " " + smallQ.poll());
            }
        }
    }
}
