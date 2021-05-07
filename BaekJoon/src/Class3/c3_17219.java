package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class c3_17219 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			Map<String, String> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				map.put(stk.nextToken(), stk.nextToken());
			}
			
			for (int i = 0; i < m; i++) {
				String s = br.readLine();
				sb.append(map.get(s)).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
