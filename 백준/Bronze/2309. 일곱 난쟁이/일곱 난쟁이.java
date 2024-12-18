import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int sum = 0;
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    if (i != k && j != k) {
                        sum += list.get(k);
                    }
                }
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if(i!=k && j!=k){
                            answer.add(list.get(k));
                        }
                    }
                    answer.sort(Comparator.naturalOrder());
                    for (int k = 0; k < 7; k++) {
                        System.out.println(answer.get(k));
                    }
                    return;
                }
            }
        }


    }
}
