class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int yI = yellow;
        int yJ = 1;
        
        int total = brown+yellow;
        
        while(true){
            // yI * yJ가 yellow가 맞을 때만 아래 로직 수행
            if(yI * yJ == yellow){
                
                int bI = yI+2;
                int bJ = yJ+2;
                while(bI*bJ != total){ // 가로 세로 찾을때까지
                    
                    if(bI*bJ > total){ // total 넘으면 나가기
                        break;
                    }
                    
                    if((bI+1)*bJ == total){ // 가로 늘렸을 때, 같으면 나가기
                        bI++;
                        break;
                    }
                    if((bJ+1)*bI == total){// 세로 늘렸을 때, 같으면 나가기
                        bJ++;
                        break;
                    }
                    // 둘 다 아니면 양쪽 다 늘리기.
                    bI++;
                    bJ++;
                }
                
                // 나왔을 때 total과 같으면 답임
                if(bI*bJ == total){
                    return new int[]{bI,bJ};
                }
            }
            
            
            // total이 아니면 yellow의 가로 세로 조절하기
            yJ++;
            yI = yellow / yJ;
        }
        // return answer;
    }
}