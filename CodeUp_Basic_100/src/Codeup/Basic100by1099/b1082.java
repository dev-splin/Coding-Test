package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1082 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int hexNum = Integer.valueOf(br.readLine().trim(),16);
			// 16진수를 10진수로 바꿔서 저장해줍니다.
			
			if(hexNum < 10)
				return;
			// A ~ F까지 입력이므로 10(A)보다 작으면 프로그램을 종료합니다.
			
			for (int i = 1; i < 16 ; ++i) {
				int result = hexNum * i;
				bw.write(Integer.toHexString(hexNum).toUpperCase() + "*");
				bw.write(Integer.toHexString(i).toUpperCase() + "=");
				bw.write(Integer.toHexString(result).toUpperCase());
				bw.newLine();
			}
			// 10진수로 계산을 한 후 16진수로 출력해줍니다. 
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
