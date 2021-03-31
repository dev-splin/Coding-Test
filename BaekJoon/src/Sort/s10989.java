package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s10989 {
	static int nums[];
	static int n;
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			nums = new int[10001];
			
			for (int i = 0; i < n; i++) {
				int index = Integer.parseInt(br.readLine());
				++nums[index]; 
			}
			
			for (int i = 1; i <= 10000; i++)
				for (int j = 0; j < nums[i]; j++) {
					bw.write(Integer.toString(i));
					bw.newLine();				
				}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
