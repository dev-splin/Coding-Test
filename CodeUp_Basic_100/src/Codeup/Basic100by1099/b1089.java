package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1089 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			if(stk.countTokens() != 3)
				return;
			
			int a = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			// 결과 값에 시작 값을 넣어줍니다. 이 결과 값에 연산을 할겁니다.
			int result = a;
			
			// 몇 번째 인지 체크해주는 변수입니다.
			int i = 1;
			
			while(n != i)
			{
				// 처음 시작값은 result에 넣어 주었기 때문에 2번 째 부터 시작합니다.
				++i;
				result += d;
			}
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

