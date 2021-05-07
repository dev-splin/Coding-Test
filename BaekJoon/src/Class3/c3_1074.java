package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_1074 {
	static int count = 0;
	static int r;
	static int c;
	static int ans;
	
	public static void partition(int row, int col, int size) {
		if(row == r && col == c ) {
			ans = count;
			return;
		}
		
		if(row <= r && r < row + size &&
				col <= c && c < col + size) {
			int nextSize = size / 2;
			partition(row, col, nextSize);
			partition(row, col + nextSize, nextSize);
			partition(row + nextSize, col, nextSize);
			partition(row + nextSize, col + nextSize, nextSize);
		} else
			count += size * size;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			
			partition(0, 0, 1<<n);
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}