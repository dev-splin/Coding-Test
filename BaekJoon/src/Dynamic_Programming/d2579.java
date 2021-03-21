package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d2579 {
	// 계단의 점수를 저장할 배열 변수
	static int stairs[];
	// n계단까지 나올 수 있는 경우의 수들 중 최대 값을 저장할 배열 변수
	static Integer memo[];
	
	// maxScore(n)은 n계단까지 나올 수 있는 경우의 수들 중 최대 값을 반환해주는 메서드 입니다.
	public static int maxScore(int num) {
		// 찾은 패턴을 식으로 표현 합니다. (n-2의 경우 + n) , (n-3의 경우 + n-1 + n)에서 n은 공통되므로 밖으로 빼주고
		// (n-2의 경우) , (n-3의 경우 + n-1) 즉, maxScore(n-2), maxScore(n-3) + stairs[n-1]로 표현할 수 있습니다.
		if(memo[num] == null) 
			memo[num] = Math.max(maxScore(num-3) + stairs[num-1], maxScore(num-2)) + stairs[num];
		
		return memo[num];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			stairs = new int[n+1];
			memo = new Integer[n+1];
			
			for (int i = 1; i <= n; i++) {
				stairs[i] = Integer.parseInt(br.readLine().trim());
			}
			
			// 쉽게 값을 유추할 수 있는 초기의 값들은 넣어주고 시작 합니다.
			memo[0] = stairs[0];
			memo[1] = stairs[1];
			// n이 1이 들어올 수도 있기 때문에 범위를 보고 2의 값을 넣어줍니다.
			if(n >= 2)
				memo[2] = stairs[1] + stairs[2];
			
			int result = maxScore(n);
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
