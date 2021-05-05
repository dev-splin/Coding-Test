package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c2_15829 {
	final static int MOD = 1234567891;
	final static int r = 31;
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			String alpha = br.readLine();
			
			long sum = 0;
			long R = 1;
			for (int i = 0; i < alpha.length(); i++) {
				sum += ((alpha.charAt(i) - 96) * R) % MOD ;
				R = (R * r) % MOD;
			}
			
			System.out.println(sum % MOD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
