import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int creditSum = 0;
        for(int i=0;i<20;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a=st.nextToken();
            if(a.equals("a"))break;
            double creidt=Double.parseDouble(st.nextToken());
            String grade=st.nextToken();
            double gradeI=0.0;
            if(grade.equals("A+"))gradeI=4.5;
            if(grade.equals("A0"))gradeI=4.0;
            if(grade.equals("B+"))gradeI=3.5;
            if(grade.equals("B0"))gradeI=3.0;
            if(grade.equals("C+"))gradeI=2.5;
            if(grade.equals("C0"))gradeI=2.0;
            if(grade.equals("D+"))gradeI=1.5;
            if(grade.equals("D0"))gradeI=1.0;
            if(grade.equals("F"))gradeI=0.0;
            if(!grade.equals("P")){
                sum+=creidt*gradeI;
                creditSum+=creidt;
            }
        }
        System.out.println(sum/creditSum);
    }
}