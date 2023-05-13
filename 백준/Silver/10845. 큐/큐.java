import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int last=-1;
        Queue<Integer> q= new LinkedList<Integer>();
        //System.out.println(q.peek());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String str= st.nextToken();
            switch(str){
                case "push":
                    Integer num = Integer.parseInt(st.nextToken());
                    q.add(num);
                    last = num;
                    break;
                case "pop":
                    Integer num2 = q.poll();
                    if(num2==null)System.out.println("-1");
                    else System.out.println(num2);
                    break;
                case "front":
                    Integer a=q.peek();
                    if(a==null)System.out.println("-1");
                    else System.out.println(a);
                    break;
                case "back":
                    if(q.peek()==null)System.out.println("-1");
                    else System.out.println(last);
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.size()==0)System.out.println("1");
                    else System.out.println("0");
                default: break;
            }
        }
    }
}
