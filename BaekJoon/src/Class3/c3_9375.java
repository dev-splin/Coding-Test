package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class c3_9375 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			
			
			for (int i = 0; i < t; i++) {
				Map<String, List<String>> clothes = new HashMap<>();
				
				int n = Integer.parseInt(br.readLine());
				for (int j = 0; j < n; j++) {
					StringTokenizer stk = new StringTokenizer(br.readLine());
					String name = stk.nextToken();
					String type = stk.nextToken();
					
					if(!clothes.containsKey(type))
						clothes.put(type, new ArrayList<>());
					
					clothes.get(type).add(name);
				}
				int count = 1;
				for(String type : clothes.keySet())
					count *= clothes.get(type).size()+1;
				
				sb.append(count-1).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
