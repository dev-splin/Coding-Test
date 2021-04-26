package Kakao.Blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class kb2021_2 {
	
	static class Solution {
		Map<String, Integer> map;
		int maxCount;
		
	    public String[] solution(String[] orders, int[] course) {
	        String[] answer = {};
	        
	        PriorityQueue<String> pq = new PriorityQueue<>();
	        
	        for(int count : course) {
	        	maxCount = 0;
	        	map = new HashMap<>();
	        	
	        	for(String order : orders)
	        		DFS(orders, order, count, 0, "");
	        
	        	map.forEach((key, value) ->{
	        		if(value >= 2 && value == maxCount)
	        			pq.add(key);
	        	});
	        }
	        
	        answer = new String[pq.size()];
	        int i = 0;
	        while(!pq.isEmpty())
	        	answer[i++] = pq.poll();
	        
	        return answer;
	    }
	    
	    public void DFS(String[] orders, String find, int count, int index, String combi) {
	    	if(count > find.length())
	    		return;
	    	
	    	for (int i = index; i < find.length(); i++) {
	    		combi += find.charAt(i);
	    		
	    		if(combi.length() < count)
	    			DFS(orders, find, count, i+1, combi);
	    		
	    		if(combi.length() == count) {
	    			if(map.containsKey(combi))
	    				break;
	    			
	    			int includeCount = 0;
	    			for(String order : orders) {
	    				
	    				boolean isPossible = true;
	    				for (int j = 0; j < combi.length(); j++) {
	    					String ch = "" + combi.charAt(j);
	    					if(!order.contains(ch))
	    						isPossible = false;
						}
	    				if(isPossible)
	    					++includeCount;
	    			}
	    			char arr[] = combi.toCharArray();
	        		Arrays.sort(arr);
	        		
	    			maxCount = Math.max(maxCount, includeCount);
	    			map.put(String.valueOf(arr), includeCount);
	    		}
	    		
	    		combi = combi.substring(0, combi.length()-1);	
			}
	    }
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		String a[] = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int b[] = {2,3,5};
		
		System.out.println(Arrays.toString(s.solution(a, b)));
	}
}
