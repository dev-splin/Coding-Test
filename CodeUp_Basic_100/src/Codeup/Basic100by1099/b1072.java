package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class b1072 {
		
	static OutputStreamWriter osw = new OutputStreamWriter(System.out);
	static BufferedWriter bw = new BufferedWriter(osw);
	static StringTokenizer stk;
	// 어디서나 사용할 수 있게 static으로 주었습니다.
	
	// 입력할 정수 개수와,입력받은 문자를 인자로 받고 입력받은 문자를 쪼갠 갯수와 입력한 정수개수를 체크해 주고 출력해주는 함수 
	public static void printNum(int count, String nums) throws Exception {
		stk = new StringTokenizer(nums);
		
		if (stk.countTokens() > count)	//입력한 숫자가 count보다 많으면 함수를 종료합니다. 
			return;
		
		while(stk.hasMoreTokens())	// 출력하는 부분
		{
			int num = Integer.parseInt(stk.nextToken());
			bw.write(Integer.toString(num));
			bw.newLine();
		}
	}
	
	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int count = Integer.parseInt(br.readLine().trim());
			// 혹시 모를 공백을 제거 해주면서 정수를 입력 받습니다.
			String nums = br.readLine();
			
			printNum(count, nums);				
							
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


