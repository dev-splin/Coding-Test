package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class c2_10816 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			Map<Integer, Integer> map = new HashMap<>();
			StringTokenizer stk = new StringTokenizer(br.readLine()); 
			
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(stk.nextToken());
				int count = 1;
				
				if(map.containsKey(num))
					count = map.get(num) + 1;
				
				map.put(num, count);
			}
			
			int m = Integer.parseInt(br.readLine());
			stk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(stk.nextToken());
				
				if(map.containsKey(num))
					sb.append(map.get(num) + " ");
				else
					sb.append("0 ");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
