import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[2];
        
        int num = 0;
        while(!"1".equals(s)){
            s = Integer.toString(ijinChg(s, answer).length() , 2);
            
            num++;
        }
        
        answer[0] = num;
        return answer;
    }
    
    public String ijinChg(String str, int[] answer){
        
        char[] arr = str.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] != '0'){
                sb.append(arr[i]);
            }else{
                answer[1]++;
            }
        }
        
        // System.out.println(sb.toString() + " / " + answer[1]);
        
        return sb.toString();
    }
}