package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class sol5 {
	
	public static class Command {
		int num;
		int id;
		
		public Command(int num, int id) {
			this.num = num;
			this.id = id;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			
			Queue<Integer> order = new LinkedList<>();
			
			stk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < t; i++)
				order.add(Integer.parseInt(stk.nextToken()));
			
			Queue<Command> cmdQ[] = new LinkedList[n+1];
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= n; i++)
				cmdQ[i] = new LinkedList<>();
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < t; i++) {
				int idx = order.poll();
				
				int id = 0;
				String cmd = "";
				int num = 0;
				
				if(cmdQ[idx].size() == 0) {
					stk = new StringTokenizer(br.readLine());
					id = Integer.parseInt(stk.nextToken());
					cmd = stk.nextToken();
					
					if(cmd.equals("acquire")) {
						num = Integer.parseInt(stk.nextToken());
						
						if(set.contains(num))
							cmdQ[idx].add(new Command(num, id));
						else
							set.add(num);
					} else if(cmd.equals("release")) {
						num = Integer.parseInt(stk.nextToken());
						
						if(set.contains(num))
							set.remove(num);
					}
				} else {
					Command c = cmdQ[idx].peek();
					id = c.id;
					cmd = "acquire";
					num = c.num;
					
					if(!set.contains(num)) {
						set.add(num);
						cmdQ[idx].poll();
					}
				}
				
				sb.append(id).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
