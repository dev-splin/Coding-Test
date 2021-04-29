package Tree_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class t1949 {
	static Integer memo[][];
	static List<Integer> childs[];
	
	public static void dfs(int cur, int parent) {
		
		for(int child : childs[cur]) {
			if(child == parent)
				continue;
			
			dfs(child, cur);
			
			memo[cur][0] += Math.max(memo[child][0], memo[child][1]);
			
			memo[cur][1] += memo[child][0];
		}
	}
		
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			memo = new Integer[n+1][2];
			childs = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++) {
				memo[i][0] = 0;
				memo[i][1] = Integer.parseInt(stk.nextToken());
				childs[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < n-1; i++) {
				stk = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(stk.nextToken());
				int node2 = Integer.parseInt(stk.nextToken());
				childs[node1].add(node2);
				childs[node2].add(node1);
			}
			
			dfs(1,0);
			
			System.out.println(Math.max(memo[1][0], memo[1][1]));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}