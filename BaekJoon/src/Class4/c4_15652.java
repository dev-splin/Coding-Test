package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_15652 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int start, int depth, String result) {
		if(depth == m) {
			sb.append(result).append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			DFS(i, depth+1, result + i + " ");
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			DFS(1,0,"");
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
