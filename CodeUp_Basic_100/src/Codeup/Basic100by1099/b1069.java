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
			// 소문자가 들어오면 대문자로 바꿔서 인식할 수 있게 했습니다.

			switch (alphabet) {
			// 스위치에는 byte, short, char(ASCII로 변경), int 처럼 정수형만 올 수 있습니다. 
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
