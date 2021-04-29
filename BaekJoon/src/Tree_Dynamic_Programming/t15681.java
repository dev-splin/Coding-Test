package Tree_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class t15681 {
	static int memo[];
	static List<Integer> childs[];
	static boolean check[];
	
	public static int dp(int root) {
		
		if(memo[root] == 0) {
			check[root] = true;
			
			for(int child : childs[root]) {
				if(check[child])
					continue;
				memo[root] += dp(child);
			}
			++memo[root];
		}
		
		return memo[root];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			
			childs = new ArrayList[n+1];
			check = new boolean[n+1];
			memo = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				childs[i] = new ArrayList<>();
			
			for (int i = 0; i < n-1; i++) {
				stk = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(stk.nextToken());
				int child = Integer.parseInt(stk.nextToken());
				
				childs[parent].add(child);
				childs[child].add(parent);
			}
			
			dp(r);
			
			for (int i = 0; i < q; i++) {
				int num = Integer.parseInt(br.readLine());
				sb.append(memo[num]+"\n");
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
