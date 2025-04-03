import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        list.sort(Comparator.naturalOrder());

        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isAnswer(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isAnswer(int index) {
        int left = 0;
        int right = list.size() - 1;
        if (left == index) {
            left++;
        }
        if (right == index) {
            right--;
        }
        int target = list.get(index);
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                right--;
                if(right==index){
                    right--;
                }
            }
            if (sum < target) {
                left++;
                if(left==index){
                    left++;
                }
            }
        }
        return false;
    }
}
