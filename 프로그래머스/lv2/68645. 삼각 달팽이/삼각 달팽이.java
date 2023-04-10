class Solution {
   
    public int[] solution(int n) {
        
        int[][] arrInt = new int[n][n];
        
        int row = -1;
        int col = 0;
        
        int num = 1;
        
        int flag = n/3;
        if(n%3 != 0) flag++;
        
        System.out.println(flag);
        int chk = 0;
        while(chk < flag){
            //아래로 이동
            row++;
            for(int i=0 ; i<n; i++){
                if( arrInt[row][col] == 0){
                    arrInt[row][col] = num++;

                    if( row != n-1 && arrInt[row+1][col] == 0) row++;
                }
            }

            //옆으로 이동
            col++;
            for(int i=0 ; i<n-1 ; i++){
                if( arrInt[row][col] == 0){
                    arrInt[row][col] = num++;

                    if(col != n-1 && arrInt[row][col+1] == 0) col++;
                }
            }

            //위로 이동
            row--;
            col--;
            for(int i=0 ; i<n-1 ; i++){
                if( arrInt[row][col] == 0){
                    arrInt[row][col] = num++;

                    if(row != 0 && col != 0 && arrInt[row-1][col-1] == 0){
                        row--;
                        col--;
                    }
                }
            }
            
            chk++;
        }
        
        int[] answer = new int[n*(n+1)/2];
        
        int idx = 0;
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(arrInt[i][j] != 0){
                    answer[idx++] = arrInt[i][j];    
                }
            }
        }
        
        return answer;
    
    }
    
}