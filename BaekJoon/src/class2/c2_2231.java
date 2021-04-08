package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class c2_2231 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int tmpNum = n;
			int digit = 0;
			
			while(tmpNum > 0) {
				tmpNum /= 10;
				++digit;
			}
			
			int startNum = n - digit * 9;
			
			if(startNum < 0)
				startNum = 0;
			
			for (int i = startNum; i < n; i++) {
				int sum = i;
				tmpNum = i;
				
				while(tmpNum > 0) {
					sum += tmpNum % 10;
					tmpNum /= 10;
				}
				
				if(sum == n) {
					System.out.println(i);
					return;
				}
			}
			
			System.out.println("0");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

