class Solution {
    public int[] solution(long n) {
        
        String str = Long.toString(n);
        
        int[] answer = new int[str.length()];
        int lastIdx = str.length() - 1;
        for(int i=0 ; i<answer.length ; i++){
            
            answer[i] = Integer.parseInt(str.substring(lastIdx-i, lastIdx-i+1));
        }
        
        return answer;
    }
}