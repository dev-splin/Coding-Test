package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c4_11444 {
	public static long MOD = 1000000007;
	
	public static long[][] mul(long A[][], long B[][]) {
		
		long result[][] = new long[2][2];
		
		result[0][0] = ((A[0][0] * B[0][0]) + (A[0][1] * B[1][0])) % MOD;
		result[0][1] = ((A[0][0] * B[0][1]) + (A[0][1] * B[1][1])) % MOD;
		result[1][0] = ((A[1][0] * B[0][0]) + (A[1][1] * B[1][0])) % MOD;
		result[1][1] = ((A[1][0] * B[0][1]) + (A[1][1] * B[1][1])) % MOD;
		
		return result;
	}
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			long n = Long.parseLong(br.readLine());
			--n;
			
			long origin[][] = {{1,0}, {0,1}};
			long A[][] = {{1,0}, {0,1}};
			
			
			while(n > 0) {
				if(n % 2 == 1)
					A = mul(A, origin);
				
				origin = mul(origin, origin);
				
				n /= 2;
			}
			
			System.out.println(A[0][0]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
