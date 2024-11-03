class Solution {
    
    static int[] numbers;
    static int target;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        bt(numbers[0], 1);
        bt(-numbers[0], 1);
        
        return answer;
    }
    
    public void bt(int sum, int depth) {
        if(depth == numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
        
        bt(sum+numbers[depth], depth+1);
        bt(sum-numbers[depth], depth+1);
    }
}