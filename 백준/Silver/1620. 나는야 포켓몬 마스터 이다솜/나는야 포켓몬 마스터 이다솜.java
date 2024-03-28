import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> orderToNamemap = new HashMap<>();
        Map<String, Integer> nameToOrdermap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String poketmonName = br.readLine();
            orderToNamemap.put(i, poketmonName);
            nameToOrdermap.put(poketmonName, i);
        }

        for (int i = 0; i < M; i++) {
            String want = br.readLine();
            if (want.charAt(0) >= '1'  && want.charAt(0) <= '9'){
                System.out.println(orderToNamemap.get(Integer.parseInt(want)));
            }
            else{
                System.out.println(nameToOrdermap.get(want));
            }
        }
    }
}
