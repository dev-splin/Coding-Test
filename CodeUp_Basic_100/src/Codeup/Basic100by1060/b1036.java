package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1036 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			char alphabet = br.readLine().charAt(0);
			// �ƽ�Ű�ڵ�� ��ȯ�ϱ� ���ؼ� ���ڿ��̾ƴ϶� ���ڷ� �޾ƾ��մϴ�.
			int ascii = (int)alphabet;
			// ����ȯ�� �ϸ� ���ڴ� �ڵ����� �ƽ�Ű�ڵ�� �޾ƿɴϴ�.
			
			bw.write(Integer.toString(ascii));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
