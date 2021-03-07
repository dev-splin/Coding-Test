package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1068 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			int num = Integer.parseInt(strNums);
			
			if(num < 0 || num > 100)
				return;
				
			switch (num / 10) {
			case 10:
			case 9 : 
				bw.write("A");
				break;
			case 8:
			case 7: 
				bw.write("B");
				break;
			case 6:
			case 5:
			case 4: 
				bw.write("C");
				break;
			default:
				bw.write("D");
				break;
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
