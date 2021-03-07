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
			// Integer.valueOf()에 16진수를 넣어줄 때 소문자면 오류가 나기 때문에 입력되는 모든 문자를 대문자로 바꾸어줍니다. 
			int changedNum = Integer.valueOf(num, 16);
			// 16진수형태의 문자열을 10진수로 바꾸어 받아옵니다.
			
			bw.write(Integer.toOctalString(changedNum));
			// 10진수를 8진수 형태의 문자열로 출력합니다.
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
