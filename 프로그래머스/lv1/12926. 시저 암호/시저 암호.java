import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr = s.toCharArray();
        
        for(int i=0 ; i<arr.length ; i++){
            char temp;
            if('a' <= arr[i] && arr[i] <= 'z'){
                
                if(arr[i] + n > 'z'){
                    temp = (char) (arr[i] + n + 'a' - 'z' - 1);
                }else{
                    temp = (char) (arr[i] + n);
                }
                
            }else if('A' <= arr[i] && arr[i] <= 'Z'){
                if(arr[i] + n > 'Z'){
                    temp = (char) (arr[i] + n + 'A' - 'Z' - 1);
                }else{
                    temp = (char) (arr[i] + n);
                }
            }else{
                temp = ' ';
            }
            sb.append(temp);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}