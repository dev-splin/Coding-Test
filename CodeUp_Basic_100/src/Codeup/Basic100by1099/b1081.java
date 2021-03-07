package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1081 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);

			if(stk.countTokens() != 2)
				return;
			// 두 개의 숫자만 입력받아야 하기 때문에 나누어진 문자가 2개가 아니면 프로그램을 종료합니다.
			
			int firstNum = Integer.parseInt(stk.nextToken());
			if (firstNum > 10)
				return;
			
			int secondNum = Integer.parseInt(stk.nextToken());
			if (secondNum > 10)
				return;
			// 나누어진 숫자가 2개인 경우에만 실행되게 했으므로 hasMoreTokens로 체크하지 않아도 됩니다.
			
			for (int i = 1; i <= firstNum; ++i) {
				for (int j = 1; j <= secondNum ; ++j) {
					bw.write(Integer.toString(i) + " " + Integer.toString(j));
					bw.newLine();
				}
			}
			// 두 숫자가 조합되는 경우의 수를 출력해줍니다.
			

			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
