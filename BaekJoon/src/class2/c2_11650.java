package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c2_11650 {
	public static class Point {
		int x;
		int y;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			Point points[] = new Point[n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				Point point = new Point();
				point.x = Integer.parseInt(stk.nextToken());
				point.y = Integer.parseInt(stk.nextToken());
				
				points[i] = point;
			}
			
			Arrays.sort(points, (a,b) -> {
				if(a.x == b.x)
					return a.y - b.y;
				
				return a.x - b.x;
			});
			
			for(Point person : points) {
				sb.append(person.x + " ");
				sb.append(person.y + "\n");
			}
			
			System.out.println(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
