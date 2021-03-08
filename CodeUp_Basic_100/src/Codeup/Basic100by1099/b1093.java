package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1093 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// 출석 번호를 부른 횟수
			int n = Integer.parseInt(br.readLine().trim());
			
			String nums = br.readLine().trim();
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			// 무작위로 부른 번호의 개수와 처음 입력한 부른 횟수가 같지 않으면 프로그램 종료
			if(stk.countTokens() != n)
				return;
			
			// 23개의 출석번호 배열을 만듭니다.
			int attendanceNum[] = new int[23];
		
			while(stk.hasMoreTokens())
			{
				int num = Integer.parseInt(stk.nextToken());
                // 입력된 숫자가 출석번호가 아니면 넘어가줍니다.
				if(num < 1 || num > 23)
					continue;
				
				// 입력될 때 첫번 째는 1 이므로 -1을 빼줍니다.
				++attendanceNum[num-1];
			}
			
			for (int i = 0; i < attendanceNum.length; ++i) {
				bw.write(Integer.toString(attendanceNum[i]) + " ");
				
			}
		
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

