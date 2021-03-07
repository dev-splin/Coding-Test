package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1038 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String num = br.readLine();
			String[] tokens = num.split(" ");
			// 공백을 기준으로 문자열을 나누어 줍니다.
			long sum = 0;
			// 합을 저장할 변수. 만약 1073741824 + 1073741824 하게 되면 정수범위를 넘어가게 되므로 long타입으로 주었습니다.
			
			for (int i = 0; i < tokens.length; i++) {
				sum += Long.parseLong(tokens[i]);
			}
			
			bw.write(Long.toString(sum));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
