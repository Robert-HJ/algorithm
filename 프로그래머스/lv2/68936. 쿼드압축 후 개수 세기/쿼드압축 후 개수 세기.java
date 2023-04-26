class Solution {
    public int[] solution(int[][] arr) {

        int[] answer = new int[2];
        
        calc(0, arr.length - 1, 0, arr.length - 1, arr, answer);
        // calc(2, 3, 0, 1, arr, answer);
        
        return answer;
    }
    
    public void calc(int stX, int endX, int stY, int endY, int[][] arr, int[] answer){
        
        boolean isSame = true;
        
        int start = arr[stY][stX];
        for(int i=stY ; i<=endY ; i++){
           for(int j=stX ; j<=endX ; j++){
               // System.out.print(arr[i][j] + ", ");
               if( arr[i][j] != start){
                   isSame = false; 
                   break;
               } 
           } 
            // System.out.println("");
        }
        
        if(isSame){
            answer[start]++;
            return;
        }
        
        // System.out.println("1. 시작 X:" + stX + ", 종료 X:" + (stX+endX)/2 + ", 시작 Y:" + stY + ", 종료 Y:" + (stY+endY)/2);
        // System.out.println("2. 시작 X:" + (stX+endX+1)/2 + ", 종료 X:" + endX + ", 시작 Y:" + stY + ", 종료 Y:" + (stY+endY)/2);
        // System.out.println("3. 시작 X:" + stX + ", 종료 X:" + (stX+endX)/2 + ", 시작 Y:" + (stY+endY+1)/2 + ", 종료 Y:" + endY);
        // System.out.println("4. 시작 X:" + (stX+endX+1)/2 + ", 종료 X:" + endX + ", 시작 Y:" + (stY+endY+1)/2 + ", 종료 Y:" + endY);
        
        calc(            stX, (stX+endX)/2,            stY, (stY+endY)/2, arr, answer );
        calc( (stX+endX+1)/2,         endX,            stY, (stY+endY)/2, arr, answer );
        calc(            stX, (stX+endX)/2, (stY+endY+1)/2,         endY, arr, answer );
        calc( (stX+endX+1)/2,         endX, (stY+endY+1)/2,         endY, arr, answer );
        
    }
}