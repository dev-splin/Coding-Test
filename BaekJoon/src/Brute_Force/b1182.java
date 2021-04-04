package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1182 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			int n = Integer.parseInt(stk.nextToken());
			int s = Integer.parseInt(stk.nextToken());
			
			int sequences[] = new int[n];
			
			nums = br.readLine();
			stk = new StringTokenizer(nums);
			
			for (int i = 0; i < n; i++) {
				sequences[i] = Integer.parseInt(stk.nextToken());
			}
			
			int count = 0;
			
			for (int i = 1; i < 1 << n ; i++) {
				int sum = 0; 
				for (int j = 0; j < n; j++) {
					if(1 << j > i)
						break;
					
					if((1<<j & i) > 0)
						sum += sequences[j];
				}
				if(sum == s)
					++count;
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
