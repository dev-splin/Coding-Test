package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class d6416 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			
			int k = 1;
			
			boolean isPossible = true;
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int u = 0;
				int v = 0;
				
				while(stk.hasMoreTokens()) {
					u = Integer.parseInt(stk.nextToken());
					v = Integer.parseInt(stk.nextToken());
					
					if(u == 0 && v == 0) {
						String prefix = "Case " + k + " is ";
						String postfix = "a tree.";
						String result = "not ";
						
						if(map.isEmpty())
							result = "";
						else {
							int count = 0;
							
							if(isPossible)
								for(Integer key : map.keySet())
									if(map.get(key) == -1)
										++count;
							
							if(count == 1)
								result = "";
						}
						
						sb.append(prefix + result + postfix).append('\n');
							
						++k;
						isPossible = true;
						map.clear();
						
					} else {
						if(!map.containsKey(u))
							map.put(u, -1);
						
						int num = map.getOrDefault(v, -1);
						
						if(num == -1)
							map.put(v, u);
						else
							isPossible = false;
					}
				}
				
				if(u == -1 && v == -1)
					break;
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
