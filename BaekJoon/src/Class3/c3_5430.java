package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class c3_5430 {
	static StringBuilder sb = new StringBuilder();;
	static ArrayDeque<Integer> ad;
	
	public static void runCmd(String cmd) {
		
		boolean isFront = true;
		
		for (int i = 0; i < cmd.length(); i++) {
			switch (cmd.charAt(i)) {
			case 'R' :
				isFront = !isFront;
				break;
			case 'D' :
				if(ad.isEmpty()) {
					sb.append("error").append("\n");
					return;
				}
				if(isFront)
					ad.removeFirst();
				else
					ad.removeLast();
				break;
			default :
				break;
			}
		}
		
		sb.append('[');
		
		while(!ad.isEmpty()) {
			if(isFront)
				sb.append(ad.removeFirst());
			else
				sb.append(ad.removeLast());
			
			if(!ad.isEmpty())
				sb.append(',');
		}
		
		sb.append(']').append("\n");
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				String cmd = br.readLine();
				int n = Integer.parseInt(br.readLine());
				
				String arr = br.readLine();
				
				if(n == 0) {
					if(cmd.contains("D"))
						sb.append("error\n");
					else
						sb.append("[]\n");
					continue;
				}
				
				ad = new ArrayDeque<>();
				StringTokenizer stk = new StringTokenizer(arr,"[],");
				while(stk.hasMoreTokens())
					ad.add(Integer.parseInt(stk.nextToken()));
				
				runCmd(cmd);
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
