import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if(abs1 == abs2){
                    return o1.compareTo(o2);
                }
                return abs1-abs2;
            }
        });

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(q.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(q.poll()+"\n");
                }
            }
            else{
                q.add(x);
            }
        }

        System.out.println(sb);
    }
}
