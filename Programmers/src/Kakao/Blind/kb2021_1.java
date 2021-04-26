package Kakao.Blind;

public class kb2021_1 {
	
	static class Solution {
	    public String solution(String new_id) {
	    	String answer = new_id.toLowerCase();
	    	answer = convertId(answer);
	        return answer;
	    }
	    
	    public String convertId(String Id) {
	    	String result = "";
	    	int count = 0;
	    	
	    	for (int i = 0; i < Id.length(); i++) {
	    		char ch = Id.charAt(i);
	    		
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
	    
	    public String checkId(String id) {
	    	String result = removePeriod(id);
	    	int length = result.length();
	    	
	    	if(length == 0) {
	    		result = "a";
	    		length = 1;
	    	}
	    	
	    	if(length >= 16)
	    		result = removePeriod(result.substring(0,15));
	    	else if(length <= 2) {
	    		char lastCh = result.charAt(length-1);
	    		for (int i = length; i < 3; i++)
	    			result += lastCh;
	    	}
	    		
	    	return result;
	    }
	    
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
