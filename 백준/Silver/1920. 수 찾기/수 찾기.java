import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /* 입력 할당 */
        int N,M;
        N=Integer.parseInt(br.readLine());
        int []number= new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            number[i]=Integer.parseInt(st.nextToken());
        }
        M=Integer.parseInt(br.readLine());
        int []targetNum=new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            targetNum[i]=Integer.parseInt(st.nextToken());
        }

        /* 정렬 */
        Arrays.sort(number);

        /* binary search */
        for(int i=0;i<M;i++){
            int first=0,last=N-1;
            int pivot;
            while(true){
                pivot=(first+last)/2;
                if(number[pivot]==targetNum[i]){
                    System.out.println("1");
                    break;
                }
                else if(number[pivot]>targetNum[i]){
                    last=pivot-1;
                }
                else{
                    first=pivot+1;
                }
                if(first>last){
                    System.out.println("0");
                    break;
                }
            }
        }
        
    }
}