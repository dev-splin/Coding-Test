package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1069 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			char alphabet = br.readLine().toUpperCase().charAt(0);
			// �ҹ��ڰ� ������ �빮�ڷ� �ٲ㼭 �ν��� �� �ְ� �߽��ϴ�.

			switch (alphabet) {
			// ����ġ���� byte, short, char(ASCII�� ����), int ó�� �������� �� �� �ֽ��ϴ�. 
			case 'A':
				bw.write("best!!!");
				break;
			case 'B':
				bw.write("good!!");
				break;
			case 'C':
				bw.write("run!");
				break;
			case 'D':
				bw.write("slowly~");
				break;
			default:
				bw.write("what?");
				break;
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
