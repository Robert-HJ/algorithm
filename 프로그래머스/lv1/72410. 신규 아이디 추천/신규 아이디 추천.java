class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        new_id = new_id.replaceAll("[.]{2,}",".");
        new_id = new_id.replaceAll("^[.]", "");
        new_id = new_id.replaceAll("[.]$", "");
        
        if("".equals(new_id)) new_id = "a";
        
        if(new_id.length() > 15) new_id = new_id.substring(0,15);
        
        new_id = new_id.replaceAll("[.]$", "");
        
        int length = new_id.length();
        while(length < 3){
            new_id = new_id + new_id.substring(new_id.length()-1,new_id.length());
            length = new_id.length();
        }
        
        
        // System.out.println(new_id);
        
        return new_id;
    }
}