import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, List<String>> list = new HashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                if (!list.containsKey(kind)) {
                    ArrayList<String> names = new ArrayList<String>();
                    names.add(name);
                    list.put(kind, names);
                } else {
                    List<String> names = list.get(kind);
                    names.add(name);
                }
            }
            int answer = 1;
            List<Integer> kindSizes = list.values()
                    .stream()
                    .map(List::size)
                    .collect(Collectors.toList());
            for (Integer kindSize : kindSizes) {
                answer = answer * (kindSize + 1);
            }

            if(kindSizes.size()==0){
                System.out.println(0);
            }else{
                System.out.println(answer-1);
            }
        }
    }
}
