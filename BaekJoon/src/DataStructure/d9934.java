package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class d9934 {
	static boolean check[][];
	static ArrayList<Integer> list[];
	static int k;
	
	public static void solve(int depth, StringTokenizer stk) {
		if(depth > k)
			return;
		
		solve(depth+1, stk);
		list[depth].add(Integer.parseInt(stk.nextToken()));
		solve(depth+1, stk);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			
			k = Integer.parseInt(br.readLine());
			
			int n = 2 << k -1;
			
			list = new ArrayList[k+1];
			
			for (int i = 1; i <= k; i++) 
				list[i] = new ArrayList<>();
			
			solve(1, new StringTokenizer(br.readLine()));
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= k; i++) {
				int size = list[i].size();
				
				sb.append(list[i].get(0));
				
				for (int j = 1; j < size; j++)
					sb.append(' ').append(list[i].get(j));
				
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
