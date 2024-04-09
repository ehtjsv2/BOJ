import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean existBaechu[][];
    static boolean isVisited[][];
    static int col;
    static int row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            existBaechu = new boolean[col][row];
            isVisited= new boolean[col][row];
            int answer = 0;

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int col1 = Integer.parseInt(st.nextToken());
                int row1 = Integer.parseInt(st.nextToken());
                existBaechu[col1][row1] = true;
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    // 배추가 있으면
                    if (existBaechu[k][j] == true) {
                        // 아직 방문안한 배추면
                        if (isVisited[k][j] == false) {
                            // 방문한다
                            isVisited[k][j] = true;
                            answer++;
                            // 위의 배추 방문
                            visit(k,j-1);
                            // 아래 배추 방문
                            visit(k,j+1);
                            // 왼쪽 배추 방문
                            visit(k-1,j);
                            // 오른쪽 배추 방문
                            visit(k+1,j);
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void visit(int nowCol, int nowRow) {
        if(nowCol>=col || nowCol<0 || nowRow>=row || nowRow<0){
            return;
        }
        if(isVisited[nowCol][nowRow] == true || existBaechu[nowCol][nowRow] == false){
            return;
        }
        isVisited[nowCol][nowRow] = true;
        //위
        visit(nowCol,nowRow-1);
        //아래
        visit(nowCol,nowRow+1);
        //왼쪽
        visit(nowCol-1,nowRow);
        //오른쪽
        visit(nowCol+1,nowRow);
    }
}
