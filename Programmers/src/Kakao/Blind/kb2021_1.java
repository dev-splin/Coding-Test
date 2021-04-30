package Kakao.Blind;

public class kb2021_1 {
	
	static class Solution {
	    public String solution(String new_id) {
	    	// id의 대문자를 소문자로 변환
	    	String answer = new_id.toLowerCase();
	    	answer = convertId(answer);
	        return answer;
	    }
	    
	    // id를 변환할 함수
	    public String convertId(String Id) {
	    	String result = "";
	    	int count = 0;
	    	
	    	for (int i = 0; i < Id.length(); i++) {
	    		char ch = Id.charAt(i);
	    		
	    		// 허용된 문자들만 String에 더해줍니다.
	    		// 이 때, '.'은 따로 체크를 해주어서 '.'이 연속될 시 count를 누적 시키고
	    		// '.'체크가 끝나고 다음 문자열이 추가될 때, '.'하나만 추가해 줍니다. 
	    		// 마지막 까지 '.'이 있을 시 추가하지 않기 때문에 자동으로 마지막의 '.'이 제거 됩니다.
	    		if((ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57) ||
	    				ch == '-' || ch == '_') {
	    			if(count > 0) {
	    				result += '.';
	    				count = 0;
	    			}
	    			
	    			result += ch;
	    			
	    		}
	    		else if(ch == '.') {
	    			++count;
	    		}
			}
	    	
	    	result = checkId(result);
	    	
	    	return result;
	    }
	    
	    
	    // Id의 길이와 '.'을 체크합니다.
	    public String checkId(String id) {
	    	String result = removePeriod(id);
	    	int length = result.length();
	  
	    	// 문자열 길이가 0 이라면 a를 추가
	    	if(length == 0) {
	    		result = "a";
	    		length = 1;
	    	}
	    	
	    	// 16자 이상이면 잘라주고 '.'제거
	    	if(length >= 16)
	    		result = removePeriod(result.substring(0,15));
	    	// 2자 이하면 마지막 문자를 3이 될 때까지 추가
	    	else if(length <= 2) {
	    		char lastCh = result.charAt(length-1);
	    		for (int i = length; i < 3; i++)
	    			result += lastCh;
	    	}
	    		
	    	return result;
	    }
	    
	    // 처음과 끝의 '.'을 제거합니다.
	    public String removePeriod(String id) {
	    	String result = "";
	    	int startIndex = 0;
	    	int endIndex = id.length();
	    	
	    	if(id.startsWith("."))
	    		++startIndex;
	    	if(id.endsWith("."))
	    		--endIndex;
	    	
	    	if(startIndex <= endIndex)
	    		result = id.substring(startIndex, endIndex);
	    	
	    	return result;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.solution("abcdefghijklmn.p"));
	}
}
