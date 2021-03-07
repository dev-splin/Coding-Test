package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1067 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			int num = Integer.parseInt(strNums);
			String sign;
			String oddAndEven;
			
			if(num >= 0)
				sign = "plus";
			else
				sign = "minus";
			
			if(num % 2 == 0)
				oddAndEven = "even";
			else
				oddAndEven = "odd";
			
			bw.write(sign);
			bw.write("\r\n");
			bw.write(oddAndEven);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
