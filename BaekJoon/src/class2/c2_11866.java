package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class c2_11866 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 1; i <= n; i++)
				list.add(i);
			
			sb.append("<");
			
			int index = -1;
			while(!list.isEmpty()) {
				for (int i = 0; i < k; i++) {
					++index;
					if(index == list.size())
						index = 0;
				}
				
				sb.append(list.get(index));
				
				if(list.size() != 1)
					sb.append(", ");
				
				list.remove(index--);
			}
			
			sb.append(">");
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
