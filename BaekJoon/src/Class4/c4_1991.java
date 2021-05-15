package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_1991 {
	static int nodes[][];
	
	public static String pre(int index) {
		if(index == 0)
			return "";
		
		String result = "";
		
		result += (char)(index + 64);
		result += pre(nodes[index][0]);
		result += pre(nodes[index][1]);
		
		return result;
	}
	
	public static String in(int index) {
		if(index == 0)
			return "";
		
		String result = "";
		
		result += in(nodes[index][0]);
		result += (char)(index + 64);
		result += in(nodes[index][1]);
		
		return result;
	}
	
	public static String post(int index) {
		if(index == 0)
			return "";
		
		String result = "";
		
		result += post(nodes[index][0]);
		result += post(nodes[index][1]);
		result += (char)(index + 64);
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			nodes = new int[n+1][2];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				char node = stk.nextToken().charAt(0);
				char left = stk.nextToken().charAt(0);
				char right = stk.nextToken().charAt(0);
				
				if(left >= 65)
					nodes[node-64][0] = left - 64;
				if(right >= 65)
					nodes[node-64][1] = right - 64;
			}
			
			System.out.println(pre(1));
			System.out.println(in(1));
			System.out.println(post(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
