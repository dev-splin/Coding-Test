package Kakao.Blind;

public class kb2021_1_2 {
	
	static class Solution {
	    public String solution(String new_id) {
	        String answer = "";
	        String temp = new_id.toLowerCase();
	        
	        // 허용된 문자를 제외한 나머지 문자들은 삭제
	        temp = temp.replaceAll("[^-_.a-z0-9]", "");
	        // '.'이 2개이상 연속되면 '.' 한 개로 치환
	        temp = temp.replaceAll("[.]{2,}", ".");
	        // 처음과 끝에 '.'이 있으면 제거
	        temp = temp.replaceAll("^[.]|[.]$", "");
	        // 길이가 0 이면 a를 추가
	        if(temp.length() == 0)
	        	temp = "a";
	        
	        // 길이가 16자 이상이면 자르고, 마지막 '.'이 있을 시 삭제
	        if(temp.length() >= 16) {
	        	temp = temp.substring(0,15);
	        	temp = temp.replaceAll("[.]$", "");
        	// 길이가 2 이하면 길이가 3이될 때까지 마지막 문자를 추가
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
