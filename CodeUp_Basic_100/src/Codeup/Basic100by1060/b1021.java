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
			// ?‹¨?–´ ?ˆ˜ê°? 50?´ ?„˜ì§? ?•Š?œ¼ë©? ë¬¸ìž ë°°ì—´?— ê·¸ëƒ¥ ???ž¥?•˜ê³?
			else
				arr = data.substring(0, 50).toCharArray();
			// 50?´ ?„˜?œ¼ë©? 50?žë§Œí¼ ?ž˜?¼?„œ ???ž¥?•©?‹ˆ?‹¤.
			
			bw.write(arr);
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
