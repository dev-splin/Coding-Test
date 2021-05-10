package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_1107 {
	static boolean brokens[];
	
	public static int find(int findNum) {
		if(findNum == 100)
			return 0;
		
		int min = Math.abs(findNum - 100);
		
		for (int i = 0; i <= 1000000; i++) {
			int push = Possible(i);
			
			if(push != -1) {
				push += Math.abs(findNum - i);
				min = Math.min(min, push);
			}
		}
		
		return min;
	}
	
	public static int Possible(int num) {
		if(num == 0)
			if(brokens[num])
				return -1;
			else
				return 1;
		
		int count = 0;
		
		while(num > 0) {
			int mod = num % 10;
			
			if(brokens[mod])
				return -1;
			
			num /= 10;
			++count;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			brokens = new boolean[10];
			StringTokenizer stk = null;
			
			if(m != 0) {
				stk = new StringTokenizer(br.readLine());
				
				for (int i = 0; i < m; i++) {
					int num = Integer.parseInt(stk.nextToken());
					brokens[num] = true;
				}
			}
			
			System.out.println(find(n));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
