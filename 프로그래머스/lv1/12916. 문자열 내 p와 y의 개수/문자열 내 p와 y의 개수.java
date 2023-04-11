class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String uppStr = s.toUpperCase();
        
        char[] arr = uppStr.toCharArray();
        
        int numP = 0;
        int numY = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == 'P') numP++;
            
            if(arr[i] == 'Y') numY++;
        }
        

        return numP==numY;
    }
}