package Kakao.Blind;

import java.util.ArrayList;

public class kb2021_7 {
	
	static class Solution {
		ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
		Integer dp[][] = new Integer[300001][2];
		int salesInfo[];
		int min = Integer.MAX_VALUE;
		
	    public int solution(int[] sales, int[][] links) {
	    	salesInfo = sales;
	    	
	    	makeGroup(links);
	    	
	        return Math.min(workshop(1, 1), workshop(1, 0));
	    }
	    
	    public void makeGroup(int[][] links) {
	    	
	    	for (int i = 0; i <= salesInfo.length; i++) {
	    		nodes.add(new ArrayList<>());
			}
	    	
	    	for (int i = 0; i < links.length; i++)
	    		nodes.get(links[i][0]).add(links[i][1]);
	    }
	    
	    public int workshop(int cur, int include) {
	    	
	    	if(dp[cur][include] != null)
	    		return dp[cur][include];
	    	
	    	int sum = 0;
	    	ArrayList<Integer> list = nodes.get(cur);
	    	
	    	if(include == 1) {
	    		for (int i = 0; i < list.size(); i++) {
	    			int next = list.get(i);
	    			sum += Math.min(workshop(next, 1), workshop(next, 0));
				}
	    		dp[cur][include] = sum + salesInfo[cur-1];
	    	} else {
	    		int min;
	    		boolean isSmallInclude = false;
	    		if(list.size() > 0)
	    			min = Integer.MAX_VALUE;
	    		else
	    			min = 0;
	    		
	    		for (int i = 0; i < list.size(); i++) {
	    			int next = list.get(i);
	    			int case1 = workshop(next, 1);
	    			int case2 = workshop(next, 0);
	    			
	    			sum += Math.min(case1, case2);
	    			
	    			if(case1 < case2)
	    				isSmallInclude = true;
	    			else
	    				min = Math.min(case1 - case2, min);
				}
	    		if(isSmallInclude)
	    			dp[cur][include] = sum;
	    		else
	    			dp[cur][include] = sum + min;
	    	}
	    	
	    	return dp[cur][include];
	    }
	}
	
	public static void main(String[] args) {
		int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
		
		int[][] links = { {10,8}, {1,9}, {9,7}, {5,4}, {1,5}, {5,10},{10,6}, {1,3}, {10,2}};
		
		Solution s = new Solution();
		System.out.println(s.solution(sales, links));
	}
}
