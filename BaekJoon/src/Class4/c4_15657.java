package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c4_15657 {
	static int n;
	static int m;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int prev, int depth, String result) {
		if(depth == m) {
			sb.append(result).append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(arr[prev] > arr[i])
				continue;
			DFS(i, depth+1, result + arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			
			arr = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			Arrays.sort(arr);
			
			DFS(1,0,"");
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
