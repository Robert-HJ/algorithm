class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<answer.length ; i++){
            
            for(int j=0 ; j<answer[i].length ; j++){
                
                for(int x=0 ; x<arr1[i].length ; x++){
                    answer[i][j] += arr1[i][x] * arr2[x][j];
                }
            }
        }
        
        return answer;
    }
}