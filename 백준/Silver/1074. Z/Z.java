
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static boolean findFlag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        divideSearch(0, size - 1, 0, size - 1, r, c);
        System.out.println(count);
    }

    private static void divideSearch(int up, int down, int left, int right, int searchRow, int searchCol) {
        if (findFlag == true) {
            return;
        }
        if (down - up == 1) {
            confirmNumberAndSearch(up, down, left, right, searchRow, searchCol);
            return;
        }
        //1 범위 안인가?
        if ((searchRow <= (up + down) / 2) && (searchCol <= (left + right) / 2)) {
            divideSearch(up, (up + down) / 2, left, (left + right) / 2, searchRow, searchCol);
            return;
        }
        count += ((down - up)/2 + 1) * ((down - up)/2 + 1); // 굳이 들어가지 않고 그 범위안의 숫자 한번에 더하기
        //2
        if ((searchRow <= (up + down) / 2) && (searchCol > (left + right) / 2)) {
            divideSearch(up, (up + down) / 2, ((left + right) / 2) + 1, right, searchRow, searchCol);
            return;
        }
        count += ((down - up)/2 + 1) * ((down - up)/2 + 1);
        //3
        if ((searchRow > (up + down) / 2) && searchCol <= (left + right) / 2) {
            divideSearch(((up + down) / 2) + 1, down, left, (left + right) / 2, searchRow, searchCol);
            return;
        }
        count += ((down - up)/2 + 1) * ((down - up)/2 + 1);
        //4
        if ((searchRow > (up + down) / 2) && (searchCol > (left + right) / 2)) {
            divideSearch(((up + down) / 2) + 1, down, ((left + right) / 2) + 1, right, searchRow, searchCol);
            return;
        }
    }

    private static void confirmNumberAndSearch(int up, int down, int left, int right, int row, int col) {
        //1
        if (up == row && left == col) {
            findFlag = true;
            return;
        }
        count++;
        //2
        if (up == row && right == col) {
            findFlag = true;
            return;
        }
        count++;
        //3
        if (down == row && left == col) {
            findFlag = true;
            return;
        }
        count++;
        //4
        if (down == row && right == col) {
            findFlag = true;
            return;
        }
        count++;
    }
}
