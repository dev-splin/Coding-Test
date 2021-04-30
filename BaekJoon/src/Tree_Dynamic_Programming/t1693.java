package Tree_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class t1693 {
	static List<Integer> nodes[];
	static int memo[][];
	static int maxColors;
	
	public static void DFS(int cur, int parent) {
		for(int node : nodes[cur]) {
			if(node == parent)
				continue;
			
			DFS(node, cur);
			
			for (int i = 1; i <= maxColors; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= maxColors; j++) {
					if(i == j)
						continue;
					min = Math.min(min, memo[node][j]);
				}
				memo[cur][i] += min;
			}
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			maxColors = (int)(Math.log10(n) / Math.log10(2));
			
			nodes = new ArrayList[n+1];
			memo = new int[n+1][maxColors+1];
			
			for (int i = 1; i <= n; i++) {
				nodes[i] = new ArrayList<>();
				for (int j = 1; j <= maxColors; j++) {
					memo[i][j] = j;
				}
			}
				
			for (int i = 0; i < n-1; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(stk.nextToken());
				int node2 = Integer.parseInt(stk.nextToken());
				
				nodes[node1].add(node2);
				nodes[node2].add(node1);
			}
			
			DFS(1,0);
			
			int min = Integer.MAX_VALUE;
			
			for (int i = 1; i <= maxColors; i++)
				min = Math.min(min, memo[1][i]);
			
			System.out.println(min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
