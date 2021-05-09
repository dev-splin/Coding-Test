package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class c3_11286 {
	
	public static class Num {
		int abs;
		int num;
		
		public Num(int abs, int num) {
			this.abs = abs;
			this.num = num;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Num> pq = new PriorityQueue<>((a,b)-> {
				if(a.abs == b.abs)
					return a.num - b.num;
				
				return a.abs - b.abs;
			});
			
			for (int i = 0; i < n; i++) {
				int cmd = Integer.parseInt(br.readLine());
				
				if(cmd == 0)
					if(pq.isEmpty())
						sb.append("0\n");
					else
						sb.append(pq.poll().num).append("\n");
				else
					pq.add(new Num(Math.abs(cmd),cmd));
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
