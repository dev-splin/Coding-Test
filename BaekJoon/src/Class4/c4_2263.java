package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_2263 {
	static int in[];
	static int post[];
	static int position[];
	static StringBuilder sb = new StringBuilder();
	
	public static void partition(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart > inEnd || postStart > postEnd) return;
		
		int root = post[postEnd];
		sb.append(root).append(' ');
		
		int mid = position[root];
		partition(inStart, mid-1, postStart, postStart + (mid - inStart) - 1);
		partition(mid+1, inEnd, postStart + (mid - inStart), postEnd - 1);
	}
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			in = new int[n+1];
			post = new int[n+1];
			position = new int[n+1];
			
			String strIn = br.readLine();
			String strPost = br.readLine();
			
			StringTokenizer stk = new StringTokenizer(strIn);
			for (int i = 1; i <= n; i++)
				in[i] = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(strPost);
			for (int i = 1; i <= n; i++)
				post[i] = Integer.parseInt(stk.nextToken());
			
			for (int i = 1; i <= n; i++)
				position[in[i]] = i;
			
			partition(1, n, 1, n);
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
