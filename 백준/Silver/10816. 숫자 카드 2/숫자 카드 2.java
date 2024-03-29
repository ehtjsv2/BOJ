import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (cards.containsKey(key)) {
                cards.put(key, cards.get(key) + 1);
            } else {
                cards.put(key, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int M=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(cards.containsKey(key)){
                sb.append(cards.get(key)).append(" ");
            }
            else{
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
    }
}