package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class c3_1764 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			Set<String> base = new HashSet<>();
			List<String> cmp = new ArrayList<>();
 			
			for (int i = 0; i < n; i++) 
				base.add(br.readLine());
			
			int count = 0;
			for (int i = 0; i < m; i++) {
				String s = br.readLine();
				if(base.contains(s)) {
					++count;
					cmp.add(s);
				}
			}
			sb.append(count).append("\n");
			
			Collections.sort(cmp);
			
			cmp.stream().forEach(i -> sb.append(i).append("\n"));
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
