import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i]=br.readLine();
        }

        Arrays.sort(arr,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
            
        });
        for(int i=0;i<N;i++){
            int presentLen = arr[i].length();
            int end = i;
            // 길이가 같은 마지막 인덱스 찾기
            for(int j=i+1;j<N;j++){
                if(presentLen==arr[j].length())end++;
                else break;
            }
            // 길이가 같은 단어들 정렬
            int cnt=1;
            for(int j=i;j<=end;j++){
                for(int k=i;k<=end-cnt;k++){
                    if(arr[k].compareTo(arr[k+1])>0){
                        String a = arr[k];
                        arr[k]=arr[k+1];
                        arr[k+1]=a;
                    }
                }
                cnt++;
            }
            // i를 정렬한 단어 마지막 인덱스로
            i=end;
        }

        for(int i=0;i<N;i++){
            if(i!=N-1 && arr[i].equals(arr[i+1])) continue;
            System.out.println(arr[i]);
        }
    }
}
