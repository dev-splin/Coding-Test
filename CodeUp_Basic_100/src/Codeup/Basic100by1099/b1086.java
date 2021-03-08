package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1086 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			// 3개의 값이 다 입력되지 않았으면 프로그램을 종료합니다.
			if(stk.countTokens() != 3)
				return;
			
			// 값을 담을 변수, 각 수의 최대 수가 들어오면 연산 값이 커지기 때문에 long으로 주었습니다.
			long w,h,b = 0;
			
			// 정해진 3개의 값만 들어오게 했기 때문에 hasNextTokens()없이 진행합니다.
			// 각 수에 맞는 범위를 체크합니다.
			w = Long.parseLong(stk.nextToken());
			if(w > 1024 || w < 1)
				return;
			
			h = Long.parseLong(stk.nextToken());
			if(h > 1024 || h < 1)
				return;
			
			b = Long.parseLong(stk.nextToken());
			if(b > 40 || b % 4 != 0)
				return;
	
			// 처음 받은 단위가 bit이기 때문에 byte로 바꾸어 줍니다.
			long bytes = (w * h * b) / 8;
			// 1024Byte == 1KB, 1024KB == 1MB 이기 때문에 1024*1024로 나누어 줍니다.
			// 이 때, 실수로 나와야 하기 때문에 형변환을 해줍니다.
			double result = (double)bytes / (1024 * 1024);
			
			bw.write(String.format("%.2f MB", result));	
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

