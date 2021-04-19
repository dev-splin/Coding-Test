package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class c2_10845 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				switch (stk.nextToken()) {
				case "push":
					queue.add(Integer.parseInt(stk.nextToken()));
					break;
				case "pop":
					if(queue.isEmpty())
						sb.append("-1\n");
					else
						sb.append(queue.pop() + "\n");
					break;
				case "size":
					sb.append(queue.size() + "\n");
					break;
				case "empty":
					if(queue.isEmpty())
						sb.append("1\n");
					else
						sb.append("0\n");
					break;
				case "front":
					if(queue.isEmpty())
						sb.append("-1\n");
					else
						sb.append(queue.peekFirst() + "\n");
					break;
				case "back":
					if(queue.isEmpty())
						sb.append("-1\n");
					else
						sb.append(queue.peekLast() + "\n");
					break;
				default:
					break;
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
