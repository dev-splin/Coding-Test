package Tree_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class t2213 {
	static int memo[][];
	static List<Integer> childs[];
	static String nums[][];
	
	public static void dfs(int cur, int parent) {
		
		for(int child : childs[cur]) {
			if(child == parent)
				continue;
			
			dfs(child, cur);
			
			if(memo[child][0] > memo[child][1]) {
				memo[cur][0] += memo[child][0];
				nums[cur][0] += nums[child][0];
			} else {
				memo[cur][0] += memo[child][1];
				nums[cur][0] += nums[child][1];
			}
			
			memo[cur][1] += memo[child][0];
			nums[cur][1] += nums[child][0];
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			memo = new int[n+1][2];
			childs = new ArrayList[n+1];
			nums = new String[n+1][2];
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				memo[i][1] = Integer.parseInt(stk.nextToken());
				nums[i][0] = "";
				nums[i][1] = i + " ";
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
			
			String result;
			if(memo[1][0] > memo[1][1]) {
				sb.append(memo[1][0]);
				result = nums[1][0];
			} else {
				sb.append(memo[1][1]);
				result = nums[1][1];
			}
			sb.append("\n");
			
			String[] arr = result.split(" ");
			
			List<Integer> list = new ArrayList<>();
			
			for(String num : arr)
				list.add(Integer.parseInt(num));
			
			Collections.sort(list);
			
			for(int num : list)
				sb.append(num + " ");
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
