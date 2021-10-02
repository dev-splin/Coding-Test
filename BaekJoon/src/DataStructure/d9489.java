package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d9489 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer stk;
			
			while(true) {
				stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int k = Integer.parseInt(stk.nextToken());
				
				if(n == 0 && k == 0)
					break;
				
				int levels[] = new int[n+1];
				levels[0] = -1;
				
				int level = -1;
				int dstIdx = 0;
				int prev = -1;
				
				stk = new StringTokenizer(br.readLine());
				
				for (int i = 1; i <= n; i++) {
					int num = Integer.parseInt(stk.nextToken());
					
					if(num == k)
						dstIdx = i;
					
					if(num != prev + 1)
						++level;
					
					levels[i] = level;
					prev = num;
				}
				
				int result = 0;
				
				for (int i = 1; i <= n; i++) {
					if(levels[i] != levels[dstIdx] && levels[levels[i]] == levels[levels[dstIdx]])
						++result;
				}
				
				sb.append(result).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
