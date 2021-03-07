package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1080 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int num = Integer.parseInt(br.readLine().trim());
			
			if(num < 0 || num > 1000)
				return;
			
			int sum = 0;
			int lastSumNum=0;
			for (int i = 1 ; i <= num; ++i)
			{
				sum += i;
				
				if(sum >= num)
				{
					lastSumNum = i;
					break;
				}
			}
			
			bw.write(Integer.toString(lastSumNum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
