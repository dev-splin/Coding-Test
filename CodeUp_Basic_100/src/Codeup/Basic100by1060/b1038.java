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
			// ������ �������� ���ڿ��� ������ �ݴϴ�.
			long sum = 0;
			// ���� ������ ����. ���� 1073741824 + 1073741824 �ϰ� �Ǹ� ���������� �Ѿ�� �ǹǷ� longŸ������ �־����ϴ�.
			
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
