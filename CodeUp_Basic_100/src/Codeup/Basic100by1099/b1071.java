package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class b1071 {
	
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	static OutputStreamWriter osw = new OutputStreamWriter(System.out);
	static BufferedWriter bw = new BufferedWriter(osw);
	// printNum() 함수에서 출력을 하기위해 class의 속성으로 주었습니다.
	// static main에서 사용할 변수나 함수에는 static을 붙여주어야 합니다.
	
	// StringTokenizer 객체를 받아 값이 있는지 확인 후, 정수로 바꾸고 0이 아닐 시 출력해주고 다시 printNum()함수를 부르는 재귀함수입니다. (0이 나올 때 까지 출력)
	public static void printNum(StringTokenizer stk) throws Exception {
		// BufferedReader나 Writer를 사용할 땐 반드시 예외처리를 해주어야 하는데 throws를 이용해 함수를 호출하는 곳에서 예외처리를 하게 해주었습니다.
		int num = 0;
		if(stk.hasMoreTokens())
			num = Integer.parseInt(stk.nextToken());

		if (num != 0)
		{
			bw.write(Integer.toString(num));
			bw.newLine();
			printNum(stk);
		}			
	}
	
	public static void main(String[] args) {
		
		
		try {
			String strnums = br.readLine();
			StringTokenizer stk = new StringTokenizer(strnums);
			// 받은 정수들을 공백(default)을 기준으로 나누어줍니다.
			
			printNum(stk);				
							
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


