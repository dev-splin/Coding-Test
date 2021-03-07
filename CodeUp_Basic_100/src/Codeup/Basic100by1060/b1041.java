package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1041 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			char character = br.readLine().charAt(0);
			 ++character;
			 // 다음 문자를 출력하기위해 +1을 더 해줍니다.
			 
			 bw.write(character);
			 bw.flush();
			 bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
