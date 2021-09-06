package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d2493 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int arr[] = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			ArrayDeque<int[]> dq = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= n; i++) {
				while(!dq.isEmpty() && dq.peekFirst()[1] < arr[i]) 
					dq.pop();
				
				if(dq.isEmpty())
					sb.append(0).append(' ');
				else
					sb.append(dq.peekFirst()[0]).append(' ');
				
				int pair[] = { i, arr[i]};
				
				dq.push(pair);
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
