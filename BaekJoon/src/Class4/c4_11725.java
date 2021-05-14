package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class c4_11725 {
	static List<Integer> childs[];
	static int parents[];
	
	public static void getParents(int cur, int parent) {
		
		for(Integer child : childs[cur]) {
			if(child == parent)
				continue;
			
			parents[child] = cur;
			getParents(child, cur);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			parents = new int[n+1];
			childs = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++)
				childs[i] = new ArrayList<>();
			
			for (int i = 0; i < n-1; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int node1 = Integer.parseInt(stk.nextToken());
				int node2 = Integer.parseInt(stk.nextToken());
				
				childs[node1].add(node2);
				childs[node2].add(node1);
			}
			
			getParents(1,0);
			
			for (int i = 2; i <= n; i++)
				sb.append(parents[i]).append("\n");
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
