package Kakao.Blind;

public class kb2021_1_2 {
	
	static class Solution {
	    public String solution(String new_id) {
	        String answer = "";
	        String temp = new_id.toLowerCase();
	        
	        temp = temp.replaceAll("[^-_.a-z0-9]", "");
	        
	        temp = temp.replaceAll("[.]{2,}", ".");
	        
	        temp = temp.replaceAll("^[.]|[.]$", "");
	        
	        if(temp.length() == 0)
	        	temp = "a";
	        
	        if(temp.length() >= 16) {
	        	temp = temp.substring(0,15);
	        	temp = temp.replaceAll("[.]$", "");
	        } else if(temp.length() <= 2)
	        	while(temp.length() < 3)
	        		temp += temp.charAt(temp.length()-1);
	        
	        answer = temp;
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("abcdefghijklmn.p"));
	}
}
