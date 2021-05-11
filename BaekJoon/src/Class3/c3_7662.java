package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class c3_7662 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				
				TreeMap<Integer, Integer> tree = new TreeMap<>();
				
				for (int j = 0; j < n; j++) {
					
					StringTokenizer stk = new StringTokenizer(br.readLine());
					
					String cmd = stk.nextToken();
					int num = Integer.parseInt(stk.nextToken());
					
					if(cmd.equals("I")) {
						int value = 0;
						if(tree.containsKey(num))
							value = tree.get(num);
						tree.put(num, ++value);
					}
					else {
						if(tree.isEmpty())
							continue;
						
						int key = 0;
						
						if(num == -1) {
							key = tree.firstKey();
							if(tree.get(key) > 1)
								tree.put(key, tree.get(key) - 1);
							else
								tree.pollFirstEntry();
						}
						else {
							key = tree.lastKey();
							if(tree.get(key) > 1)
								tree.put(key, tree.get(key) - 1);
							else
								tree.pollLastEntry();
						}
					}
				
				}
				if(tree.isEmpty())
					sb.append("EMPTY").append("\n");
				else {
					sb.append(tree.lastKey()).append(' ');
					sb.append(tree.firstKey()).append("\n");
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

