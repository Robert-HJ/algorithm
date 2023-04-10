import java.util.*;

class Solution {
    public int solution(String s) {
        /*
            1. 압축개수는 입력받은 s 길이의 절반이 최대
            2. 압축개수 단위를 1부터 최대 길이까지 하나씩 늘리며 확인
            3. 압축을 그때그때 해보며 줄어든 문자열의 길이값을 저장하고 그 전 값과 비교해가며 실시간으로 가장 짧은 길이 업데이트.
            4. 단순하게 이렇게 압축개수 단위로 하나씩 비교하는게 아니라 좀 더 짧게 비교할 수 있는 방법이 있을까 ?
            
            *문자열을 입력받은 압축개수 단위로 압축하여 그 길이를 반환하는 함수
        */
        
        int answer = s.length();
        for(int i=1 ;i<=s.length()/2 ; i++){
            int temp = zipString(s, i);
            if(answer > temp){
                answer = temp;
            }
        }
        
        return answer;
    }
    
    public int zipString(String s, int num){
        
        String answer = "";
        
        int equalCnt = 1;
        String word = "";
        
        int stIdx = 0;
        int endIdx = num;
        
        while(true){
            
            String str1 = s.substring(stIdx, endIdx);
            String str2 = s.substring(stIdx+num, endIdx+num);
           
            word = str1;
            
            if(str1.equals(str2)){
                equalCnt++;
            }else{
                if(equalCnt > 1){
                    answer += equalCnt + word;
                }else{
                    answer += s.substring(stIdx, endIdx);
                }
                equalCnt = 1;
            }
            
            stIdx  += num;
            endIdx += num;
            
            // System.out.println("(" + str1 + ", " + str2 + ")");
            
            
            // 다음 비교대상이 길이를 넘어갈 경우 남아있는 문자열들에 대한 처리
            if( (endIdx + num) > s.length()){
                if(equalCnt > 1){
                    answer += equalCnt + word + s.substring(endIdx);
                }else{
                    answer += s.substring(stIdx);
                }
                break;
            }
        }
        
        // System.out.println(answer.length() + ": " + answer);
        
        return answer.length();
    }
    
}