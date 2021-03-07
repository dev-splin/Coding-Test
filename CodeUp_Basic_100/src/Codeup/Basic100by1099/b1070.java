package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1070 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String month = br.readLine();
			int num = Integer.parseInt(month);
				
			switch (num) {
			case 12:
			case 1:
			case 2:
				bw.write("winter");
				break;
			case 3:
			case 4:
			case 5:
				bw.write("spring");
				break;
			case 6:
			case 7:
			case 8:
				bw.write("summer");
				break;
			default:
				bw.write("fall");
				break;
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
