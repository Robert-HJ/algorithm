import java.util.*;

class Solution {
    public String[] solution(int[][] lines) {
        /*
            Param : int[라인수][3]
            Return : String[]
            
            프로세스 : 입력받은 파라미터를 이중 반복으로 돌려 교점을 찾아내고 이 중 정수인 것들만 객체에 모은다
                     객체에 쌓인 정수 교점들을 이용해 반환할 크기를 구해내고 교점들을 찍어 반환한다.
                     
            객체 : 좌표를 속성으로 가짐. toStirng, equals, hashCode를 오버라이딩 하여 Set구조로 사용할 수 있도록 생성
        */
        
        Set<Spot> spotSet = new HashSet<Spot>();
        
        //n*n 복잡도로 반복하여 교점을 찾아 Set구조에 세팅
        for(int i=0 ; i<lines.length ; i++){   
            for(int j=i+1 ; j<lines.length ; j++){
                chkSpot(lines[i], lines[j], spotSet);
            }
        }

        return drawResult(spotSet);
    }
    
    //정수 교점을 받아 결과 그려내기
    public String[] drawResult(Set<Spot> spots){
        
        //Set에서 Spot객체를 하나 가져와 초기값 세팅
        long maxX = 0;
        long minX = 0;
        long maxY = 0;
        long minY = 0;
        
        for(Spot spot : spots){
            maxX = spot.getX();
            minX = spot.getX();
            maxY = spot.getY();
            minY = spot.getY();
            break;
        }
        
        for(Spot spot : spots){
            if(maxX < spot.getX()) maxX = spot.getX();
            
            if(minX > spot.getX()) minX = spot.getX();
            
            if(maxY < spot.getY()) maxY = spot.getY();
            
            if(minY > spot.getY()) minY = spot.getY();
            
        }
        
        int sizeW = (int) (maxX - minX + 1);
        int sizeH = (int) (maxY - minY + 1);
        
        String[] answer = new String[sizeH];
        
        for(int i=0 ; i<sizeH ; i++){
            String ans = "";
            for(int j=0 ; j<sizeW ; j++){
                long convertX = j + minX;
                long convertY = (i - maxY)*(-1);
                
                if(spots.contains(new Spot(convertX, convertY))) {
                    ans += "*";
                }else{
                    ans += ".";
                }
            }
            answer[i] = ans;
        }
        
        return answer;
    }
    
    public void chkSpot(int[] line1, int[] line2, Set<Spot> spotSet){
        
        long a1 = (long) line1[0];
        long b1 = (long) line1[1];
        long c1 = (long) line1[2];
        
        long a2 = (long) line2[0];
        long b2 = (long) line2[1];
        long c2 = (long) line2[2];
        
        //X값 구하기
        long notZero = (long) (a1*b2 - a2*b1);
        if(notZero == 0){
            //안 만나는 선
            return;
        }
        
        long temp = (long) ((b1*c2 - b2*c1)%notZero);
        if(temp != 0){
            //x값이 정수가 아님
            return;
        }    
        
        long xVal = (long) ((b1*c2 - b2*c1)/notZero); //X 값
        
        //Y값 구하기
        temp = (long) ((a2*c1 - a1*c2)%notZero); 
        if(temp != 0) {
            //y값이 정수가 아님
            return;
        }
        
        long yVal = (long) ((a2*c1 - a1*c2)/notZero);
        
        //교점 추가
        spotSet.add(new Spot(xVal, yVal));
    }
    
    public class Spot{
        private long x;
        private long y;
        
        public Spot(long x, long y){
            this.setX(x);
            this.setY(y);
        }
        
        public long getX(){
            return x;
        }
        
        public void setX(long x){
            this.x = x;
        }
        
        public long getY(){
            return y;
        }
        
        public void setY(long y){
            this.y = y;
        }
        
        @Override
        public String toString(){
            return getX() + ", " + getY();
        }
        
        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            
            if(!(obj instanceof Spot)) return false;
            
            Spot spot = (Spot) obj;
            
            if(getX() == spot.getX() && getY() == spot.getY()){
                return true;
            }else{
                return false;
            }
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}