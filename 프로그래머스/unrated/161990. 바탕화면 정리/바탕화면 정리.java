class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int Hmin=Integer.MAX_VALUE,Wmin=Integer.MAX_VALUE;
        int Hmax=Integer.MIN_VALUE,Wmax=Integer.MIN_VALUE;
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[0].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(Hmin>i)Hmin=i;
                    if(Hmax<i+1)Hmax=i+1;
                    if(Wmin>j)Wmin=j;
                    if(Wmax<j+1)Wmax=j+1;
                }
            }
        }
        answer[0]=Hmin;
        answer[1]=Wmin;
        answer[2]=Hmax;
        answer[3]=Wmax;
        
        return answer;
    }
}