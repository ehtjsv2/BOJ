import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Solution {
    public int solution(int[][] targets) {
         int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
        });
        int end = 0;
        for(int i=0;i<targets.length;i++){
            if(end<=targets[i][0]){
                end = targets[i][1];
                answer++;
            }
        }

        return answer;
    
    }
}