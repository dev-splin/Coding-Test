package Kakao.Blind;

public class kb2021_4 {

	static class Solution {
		final int INF = 1000000;
		
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	    	
	    	int taxi[][] = new int[n+1][n+1];
	    	
	    	for (int i = 0; i < fares.length; i++) {
	    			taxi[fares[i][0]][fares[i][1]] = fares[i][2];
	    			taxi[fares[i][1]][fares[i][0]] = fares[i][2];
			}
	    	
	    	for (int i = 1; i <= n; i++) {
	    		for (int j = 1; j <= n; j++) {
	    			if(i==j)
	    				continue;
	    			if(taxi[i][j] == 0)
	    				taxi[i][j] = INF;
				}
			}
	    	
	    	for (int k = 1; k <= n; k++)
	    		for (int i = 1; i <= n; i++)
	    			for (int j = 1; j <= n; j++)
	    				if(taxi[i][j] > taxi[i][k] + taxi[k][j])
	    					taxi[i][j] = taxi[i][k] + taxi[k][j];
	    	
	    	int answer = taxi[s][a] + taxi[s][b];
	    	for (int i = 1; i <= n; i++) {
	    		if(s == i)
	    			continue;
	    		
	    		int temp = taxi[s][i] + taxi[i][a] + taxi[i][b];
	    		answer = Math.min(answer, temp);
			}
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(6, 4, 6, 2, null));
	}
}
