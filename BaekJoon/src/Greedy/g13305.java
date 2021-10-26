package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g13305 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			long sum = 0;
			
			StringTokenizer dist = new StringTokenizer(br.readLine());
			StringTokenizer price = new StringTokenizer(br.readLine());
			
			long curPrice = 2000000000;
			
			while(dist.hasMoreTokens()) {
				long curDist = Integer.parseInt(dist.nextToken());
				long nextPrice = Integer.parseInt(price.nextToken());
				
				curPrice = Math.min(curPrice, nextPrice);
				
				sum += curDist * curPrice;
			}
			
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
