package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1037 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
	
		try {
			String num = br.readLine();
			int intNum = Integer.parseInt(num);
			byte byteNum = (byte)intNum; 
			char ascii = (char)(byteNum & 0xff);
			// 하지만 java의 byte는 unsigned를 지원해주지 않기 때문에 비트연산을 통해 0~255로 만들어줍니다.(256이 입력되면 0으로 인식합니다.)
			
			bw.write(String.valueOf(ascii));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
