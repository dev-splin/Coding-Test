package RegularExpression;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class r1013 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				String str = br.readLine();
				
				if(str.matches("(100+1+|01)+"))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

