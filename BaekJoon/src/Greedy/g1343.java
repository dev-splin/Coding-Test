package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g1343 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringBuilder sb = new StringBuilder(br.readLine());
			
			StringTokenizer stk = new StringTokenizer(sb.toString(), ".");
			
			int index = 0;
			boolean isPossible = true;
			
			while(stk.hasMoreTokens()) {
				while(index < sb.length() && sb.charAt(index) == '.')
					++index;
				
				int curLength = stk.nextToken().length();
				
				if(curLength % 2 != 0) {
					isPossible = false;
					break;
				}
				
				int count = 0;
				
				if(curLength >= 4) {
					count = (curLength / 4) * 4;
					
					for (int i = index; i < index + count; i++)
						sb.setCharAt(i, 'A');
					
					index += count;
					curLength -= count;
				}
				
				if(curLength == 2) {
					sb.setCharAt(index++, 'B');
					sb.setCharAt(index++, 'B');
				}
			}
			
			if(isPossible) {
				System.out.println(sb.toString());
				
			}
			else
				System.out.println(-1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
