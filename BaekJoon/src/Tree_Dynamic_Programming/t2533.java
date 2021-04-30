package Tree_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class t2533 {
	static List<Integer> friends[];
	static int memo[][];
	
	public static void DFS(int cur, int parent) {
		
		for(int friend : friends[cur]) {
			if(friend == parent)
				continue;
			
			DFS(friend, cur);
			
			memo[cur][0] += memo[friend][1];
			memo[cur][1] += Math.min(memo[friend][0], memo[friend][1]);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			friends = new ArrayList[n+1];
			memo = new int[n+1][2];
			
			for (int i = 1; i <= n; i++) {
				friends[i] = new ArrayList<>();
				memo[i][1] = 1;
			}
			
			for (int i = 0; i < n-1; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(stk.nextToken());
				int node2 = Integer.parseInt(stk.nextToken());
				
				friends[node1].add(node2);
				friends[node2].add(node1);				
			}

			DFS(1,0);
			
			System.out.println(Math.min(memo[1][0], memo[1][1]));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
