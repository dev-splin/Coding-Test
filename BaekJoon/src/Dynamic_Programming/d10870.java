package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d10870 {
	static Integer memo[];
	
	public static int fibonacci(int n) {
		if(memo[n] == null) {
			memo[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		
		return memo[n];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			memo = new Integer[n+1];
			
			memo[0] = 0;
			if(n >= 1)
				memo[1] = 1;
			if(n >= 2)
				memo[2] = 1;
			
			bw.write(Integer.toString(fibonacci(n)));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
