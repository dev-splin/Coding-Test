package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class c2_2798 {
	static int max = 0;
	static int sum = 0;
	static int cards[];
	static int n,m;
	static int count = 0;
	static boolean check[];
	
	public static void DFS() {
		if(count >= 3) {
			if(sum > max && sum <= m)
				max = sum;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			
			if(check[i])
				continue;
			
			++count;
			check[i] = true;
			sum += cards[i];
			DFS();
			--count;
			check[i] = false;
			sum -= cards[i];
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		StringBuilder sb = new StringBuilder();
		
		
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			cards = new int[n];
			check = new boolean[n];
			
			nums = br.readLine();
			stk = new StringTokenizer(nums);
			
			for (int i = 0; i < n; i++) 
				cards[i] = Integer.parseInt(stk.nextToken());
			
			DFS();
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}