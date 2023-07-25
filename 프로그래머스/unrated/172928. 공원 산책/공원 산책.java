class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] coord =new char[park.length][park[0].length()];
        int H=0;//세로
        int W=0;//가로
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                coord[i][j]=park[i].charAt(j);
                if(park[i].charAt(j)=='S'){
                    H=i;W=j;
                }
            }
        }
        int move=0;
        
        for (int i = 0; i < routes.length; i++) {
            move = routes[i].charAt(2)-48;
            int isX = 0;
            switch (routes[i].charAt(0)) {
                case 'E':
                    if(W+move>=park[0].length())break;
                    for(int j=W;j<=W+move;j++){
                        if(coord[H][j]=='X'){
                            isX=1;
                            break;
                        }
                    }
                    if(isX==0)W=W+move;
                    break;
                case 'W':
                    if(W-move<0)break;
                    for(int j=W;j>=W-move;j--){
                        if(coord[H][j]=='X'){
                            isX=1;
                            break;
                        }
                    }
                    if(isX==0)W=W-move;
                    break;
                case 'N':
                    if(H-move<0)break;
                    for(int j=H;j>=H-move;j--){
                        if(coord[j][W]=='X'){
                            isX=1;
                            break;
                        }
                    }
                    
                    if(isX==0)H=H-move;
                    break;
                case 'S':
                    if(H+move>=park.length)break;
                    for(int j=H;j<=H+move;j++){
                        if(coord[j][W]=='X'){
                            isX=1;
                            break;
                        }
                    }
                    if(isX==0)H=H+move;
                    break;

                default:
                    break;
            }
        }
        answer[0]=H;
        answer[1]=W;

        // System.out.println("["+H+","+W+"]");
        return answer;
    }
}