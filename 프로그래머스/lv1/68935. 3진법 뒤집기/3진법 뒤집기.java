class Solution {
    public int solution(int n) {
        
        /*
             N 진법 변환
            => N으로 나누어 그 나머지를 한 자리씩 채워간다.
              ex) 45를 3진법 변환
                 - 45/3 = 15 ... 0
                 - 15/3 =  5 ... 0
                 -  5/3 =  1 ... 2
                 -  1/3 =  0 ... 1
                 => 1200
        */
        return chgNumber(n);
    }
    
    public int chgNumber(int num){
        
        int mok    = num;
        int namuji = 0;
        
        String str = "";
        
        while(mok > 0){
            str += Integer.toString(mok%3);
            mok = mok/3;
        }
        
        System.out.println(str);
        
        int answer = 0;
        
        int sqlt = 1;
        for(int i=0 ; i<str.length() ; i++){
            // System.out.println(str.substring(str.length()-1-i, str.length()-i));
            answer += Integer.parseInt(str.substring(str.length()-1-i, str.length()-i)) * sqlt;
            
            sqlt = sqlt * 3;
        }
        
        // System.out.println(answer);
        
        return answer;
    }     
}