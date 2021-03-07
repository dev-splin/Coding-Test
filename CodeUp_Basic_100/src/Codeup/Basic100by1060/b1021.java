package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1021 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			char[] arr; 
			String data = br.readLine();
			
			if (data.length() < 50)	
				arr = data.toCharArray();
			// ?¨?΄ ?κ°? 50?΄ ?μ§? ??Όλ©? λ¬Έμ λ°°μ΄? κ·Έλ₯ ???₯?κ³?
			else
				arr = data.substring(0, 50).toCharArray();
			// 50?΄ ??Όλ©? 50?λ§νΌ ??Ό? ???₯?©??€.
			
			bw.write(arr);
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
