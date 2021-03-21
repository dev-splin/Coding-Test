package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1920 {
	static int A[];
	
	public static boolean findNum(int num) {
		
		int start = 0;
		int end = A.length - 1;
		
		if(num == A[start] || num == A[end]) {
			return true;
		}
				
		while(true) {
			int mid = (start + end) / 2;
			
			if(mid == start || mid == end)
				break;
			
			if(num == A[mid])
				return true;
			
			if(num < A[mid]) 
				end = mid;
			else
				start = mid;
		}
		
		return false;
	}

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			A = new int[n];
			
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			for (int i = 0; i < A.length; i++) 
				A[i] = Integer.parseInt(stk.nextToken());
			
			Arrays.sort(A);
			
			int m = Integer.parseInt(br.readLine().trim());
			
			nums = br.readLine().trim();
			stk = new StringTokenizer(nums);
			
			for (int i = 0; i < m; i++) { 
				int num = Integer.parseInt(stk.nextToken());
				
				if(findNum(num))
					bw.write("1");
				else
					bw.write("0");
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
