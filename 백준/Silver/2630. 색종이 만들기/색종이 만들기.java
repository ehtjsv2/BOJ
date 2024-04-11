import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean arr[][];
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new boolean[N][N];
        boolean isExistOtherColor = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
                if (arr[0][0] != arr[i][j]) {
                    isExistOtherColor = true;
                }
            }

        }
        if(isExistOtherColor==true){
            //1
            recur(0, N / 2 - 1, 0, N / 2 - 1);
            //2
            recur(0, N / 2 - 1, N / 2, N - 1);
            //3
            recur(N / 2, N - 1, 0, N / 2 - 1);
            //4
            recur(N / 2, N - 1, N / 2, N - 1);
        }
        else{
            if(arr[0][0]==true){
                blueCount++;
            }
            else{
                whiteCount++;
            }
        }
        System.out.println(whiteCount+"\n"+blueCount);
    }

    private static void recur(int up, int down, int left, int right) {
        boolean firstColor = arr[up][left];
        boolean isExistOtherColor = false;
        // 다른 색이 있는 지
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (firstColor != arr[i][j]) {
                    isExistOtherColor = true;
                    break;
                }
            }
            if (isExistOtherColor == true) {
                break;
            }
        }
        // 다른 색이 있다면
        if (isExistOtherColor == true) {
            //1
            recur(up, (up + down) / 2, left, (left + right) / 2);
            //2
            recur(up, (up + down) / 2, ((left + right) / 2) + 1, right);
            //3
            recur(((up + down) / 2) + 1, down, left, (left + right) / 2);
            //4
            recur(((up + down) / 2) + 1, down, ((left + right) / 2) + 1, right);
        } else {
            // 다른 색이 없다면
            if (firstColor == true) {
                blueCount++;
            } else {
                whiteCount++;
            }
        }
    }
}
