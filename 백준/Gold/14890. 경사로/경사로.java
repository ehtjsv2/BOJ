import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        List<List<Count>> rowCounts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Count> rowCount = new ArrayList<>();
            int num = arr[i][0];
            int numCount = 1;
            for (int j = 1; j < N; j++) {
                if(num == arr[i][j]){
                    numCount++;
                } else {
                    rowCount.add(new Count(num,numCount));
                    num = arr[i][j];
                    numCount = 1;
                }
            }
            rowCount.add(new Count(num, numCount));
            rowCounts.add(rowCount);
        }

        List<List<Count>> columnCounts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Count> columnCount = new ArrayList<>();
            int num = arr[0][i];
            int numCount = 1;
            for (int j = 1; j < N; j++) {
                if(num == arr[j][i]){
                    numCount++;
                } else {
                    columnCount.add(new Count(num,numCount));
                    num = arr[j][i];
                    numCount = 1;
                }
            }
            columnCount.add(new Count(num, numCount));
            columnCounts.add(columnCount);
        }

        int answer =0;
        answer+=getAnswer(rowCounts);
        answer+=getAnswer(columnCounts);

        System.out.println(answer);
    }

    public static int getAnswer(List<List<Count>> inputCounts){
        int answer = 0;
        for (int i = 0; i < inputCounts.size(); i++) {
            List<Count> counts = inputCounts.get(i);
            boolean isAnswer = true;
            int beforeNum = counts.get(0).number;
            int beforeCount = counts.get(0).count;
            for (int j = 1; j < counts.size(); j++) {
                int nowNum = counts.get(j).number;
                int nowCount = counts.get(j).count;
                if(nowNum-beforeNum == 1){ // 올라감
                    if(beforeCount>=L){
                        counts.get(j-1).count-=L;
                    }
                    else{
                        isAnswer = false;
                    }
                }
                else if(nowNum - beforeNum == -1){ // 내려감
                    if(nowCount>=L){
                        counts.get(j).count-=L;
                    }
                    else{
                        isAnswer = false;
                    }
                }
                else{
                    isAnswer = false;
                }

                if(isAnswer == false){
                    break;
                }
                beforeNum = counts.get(j).number;
                beforeCount = counts.get(j).count;
            }
            if(isAnswer == true){
                answer++;
            }
        }
        return answer;
    }

    static class Count{
        int number;
        int count;

        Count(int number, int count){
            this.number = number;
            this.count = count;
        }
    }
}
