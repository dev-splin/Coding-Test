package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class q18258 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				String cmd = stk.nextToken();
				
				switch (cmd) {
					case "push":
						int num = Integer.parseInt(stk.nextToken());
						dq.addLast(num);
						break;
					case "pop":
						if(dq.isEmpty())
							sb.append("-1");
						else
							sb.append(dq.pollFirst());
						break;
					case "size":
						sb.append(dq.size());
						break;
					case "empty":
						if(dq.isEmpty()) 
							sb.append("1");
						else 
							sb.append("0");
						break;
					case "front":
						if(dq.isEmpty())
							sb.append("-1");
						else
							sb.append(dq.peekFirst());
						break;
					case "back":
						if(dq.isEmpty())
							sb.append("-1");
						else
							sb.append(dq.peekLast());
						break;
					default:
						break;
				}
				
				if(!cmd.equals("push"))
					sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
