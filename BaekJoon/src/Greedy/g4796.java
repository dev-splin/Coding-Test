package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class g4796 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			List<Integer> testCases = new ArrayList<>();
			
			while(true) {
				String testCase = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(testCase);
				
				// l,p,v를 토큰으로 나눈 후 받아옵니다.
				int l = Integer.parseInt(stk.nextToken());
				int p = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				
				// 0이 입력되면 종료
				if (l == 0 && p == 0 && v == 0)
					break;
				
				// 총 사용할 수 있는 날을 저장하는 변수
				int availableDays = (v / p) * l;
				// 남은 날을 저장하는 변수
				int restDays = v % p;
				
				// 남은 날이 사용할 수 있는 날(l)보다 작으면 바로 총사용할 날에 더하고 아니면 l을 더합니다. 
				if(restDays < l)
					availableDays += restDays;
				else
					availableDays += l;

				testCases.add(availableDays);
			}
			
			// 출력
			for (int i = 0; i < testCases.size(); i++) {
				bw.write("Case " + Integer.toString(i+1) + ": " + Integer.toString(testCases.get(i)));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
