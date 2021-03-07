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
			// 16������ 10������ �ٲ㼭 �������ݴϴ�.
			
			if(hexNum < 10)
				return;
			// A ~ F���� �Է��̹Ƿ� 10(A)���� ������ ���α׷��� �����մϴ�.
			
			for (int i = 1; i < 16 ; ++i) {
				int result = hexNum * i;
				bw.write(Integer.toHexString(hexNum).toUpperCase() + "*");
				bw.write(Integer.toHexString(i).toUpperCase() + "=");
				bw.write(Integer.toHexString(result).toUpperCase());
				bw.newLine();
			}
			// 10������ ����� �� �� 16������ ������ݴϴ�. 
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
