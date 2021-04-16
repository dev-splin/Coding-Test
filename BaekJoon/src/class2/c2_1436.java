package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c2_1436 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			int num = 666;
			int count = 1;
			
			while(n > count) {
				++num;
				
				if(String.valueOf(num).contains("666"))
					++count;
			}
			
			System.out.println(num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

