package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class d14425 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			Set<String> set = new HashSet<>();
			
			for (int i = 0; i < n; i++)
				set.add(br.readLine());
			
			int count = 0;
			
			for (int i = 0; i < m; i++)
				if(set.contains(br.readLine()))
					++count;
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
