package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b15649 {
	static OutputStreamWriter osw = new OutputStreamWriter(System.out);
	static BufferedWriter bw = new BufferedWriter(osw);
	static int m,n;
	static boolean[] check;
	static int[] outputNum;
	static StringBuilder stringBuilder = new StringBuilder();
	
	public static void DFS(int depth) throws Exception{
		if(m < depth) {
			for (int i = 1; i <= m; i++)
				stringBuilder.append(outputNum[i]).append(' ');
			stringBuilder.append('\n');
//			for (int i = 1; i <= m; i++)
//				bw.write(Integer.toString(outputNum[i]) + " ");
//			bw.newLine();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!check[i]) {
				
				outputNum[depth] = i; 
				
				check[i] = true;
				DFS(depth+1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			check = new boolean[n+1];
			outputNum = new int[m+1];
			
			DFS(1);
			
			bw.write(stringBuilder.toString());
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
