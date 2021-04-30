package Kakao.Blind;

public class kb2021_1 {
	
	static class Solution {
	    public String solution(String new_id) {
	    	// id�� �빮�ڸ� �ҹ��ڷ� ��ȯ
	    	String answer = new_id.toLowerCase();
	    	answer = convertId(answer);
	        return answer;
	    }
	    
	    // id�� ��ȯ�� �Լ�
	    public String convertId(String Id) {
	    	String result = "";
	    	int count = 0;
	    	
	    	for (int i = 0; i < Id.length(); i++) {
	    		char ch = Id.charAt(i);
	    		
	    		// ���� ���ڵ鸸 String�� �����ݴϴ�.
	    		// �� ��, '.'�� ���� üũ�� ���־ '.'�� ���ӵ� �� count�� ���� ��Ű��
	    		// '.'üũ�� ������ ���� ���ڿ��� �߰��� ��, '.'�ϳ��� �߰��� �ݴϴ�. 
	    		// ������ ���� '.'�� ���� �� �߰����� �ʱ� ������ �ڵ����� �������� '.'�� ���� �˴ϴ�.
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
	    
	    
	    // Id�� ���̿� '.'�� üũ�մϴ�.
	    public String checkId(String id) {
	    	String result = removePeriod(id);
	    	int length = result.length();
	  
	    	// ���ڿ� ���̰� 0 �̶�� a�� �߰�
	    	if(length == 0) {
	    		result = "a";
	    		length = 1;
	    	}
	    	
	    	// 16�� �̻��̸� �߶��ְ� '.'����
	    	if(length >= 16)
	    		result = removePeriod(result.substring(0,15));
	    	// 2�� ���ϸ� ������ ���ڸ� 3�� �� ������ �߰�
	    	else if(length <= 2) {
	    		char lastCh = result.charAt(length-1);
	    		for (int i = length; i < 3; i++)
	    			result += lastCh;
	    	}
	    		
	    	return result;
	    }
	    
	    // ó���� ���� '.'�� �����մϴ�.
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
