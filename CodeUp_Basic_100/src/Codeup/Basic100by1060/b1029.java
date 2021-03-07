package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1029 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String num = br.readLine();
			double realNum = Double.parseDouble(num);
			
			bw.write(String.format("%.11f", realNum)); 
			// String.format()?�� ?��?��?�� ?�� "%.11f"�? ?��?��?�� ?���? ?���? �??��?��주면 �? ?��?��?�� ?��?��?��?? ?��?��?���? 반올림됩?��?��.
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
