package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1035 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String num = br.readLine().toUpperCase();
			// Integer.valueOf()�� 16������ �־��� �� �ҹ��ڸ� ������ ���� ������ �ԷµǴ� ��� ���ڸ� �빮�ڷ� �ٲپ��ݴϴ�. 
			int changedNum = Integer.valueOf(num, 16);
			// 16���������� ���ڿ��� 10������ �ٲپ� �޾ƿɴϴ�.
			
			bw.write(Integer.toOctalString(changedNum));
			// 10������ 8���� ������ ���ڿ��� ����մϴ�.
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
