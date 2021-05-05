package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c2_4153 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		StringBuilder sb = new StringBuilder();
		
		try {
			
			while(true) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				int triangle[] = new int[3];
				triangle[0] = Integer.parseInt(stk.nextToken());
				triangle[1] = Integer.parseInt(stk.nextToken());
				triangle[2] = Integer.parseInt(stk.nextToken());
				
				if(triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0)
					break;
				
				Arrays.sort(triangle);
				
				int cSquare = (int)Math.pow(triangle[2],2);
				int abSquare = (int)Math.pow(triangle[0],2) + (int)Math.pow(triangle[1],2); 
				
				if(cSquare == abSquare) {
					System.out.println("right");
					continue;
				} else
					System.out.println("wrong");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

