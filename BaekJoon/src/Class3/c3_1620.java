package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class c3_1620 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			Map<Integer, String> numkeyMap = new HashMap<>();
			Map<String, Integer> stringkeyMap = new HashMap<>();
			
			for (int i = 1; i <= n; i++) {
				String pocketmon = br.readLine();
				numkeyMap.put(i, pocketmon);
				stringkeyMap.put(pocketmon, i);
			}
			
			for (int i = 1; i <= m; i++) {
				String str = br.readLine();
				
				if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
					int num = Integer.parseInt(str);
					sb.append(numkeyMap.get(num)).append("\n");
				}
				else
					sb.append(stringkeyMap.get(str)).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}