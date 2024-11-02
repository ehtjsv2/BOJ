import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        
        for(int i=0; i<A.length; i++){
            a.add(A[i]);
        }
        for(int i=0; i<B.length; i++){
            b.add(B[i]);
        }
        
        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.reverseOrder());
        
        int answer = 0;
        for(int i=0; i<A.length; i++){
            answer += a.get(i)*b.get(i);
        }

        return answer;
    }
}