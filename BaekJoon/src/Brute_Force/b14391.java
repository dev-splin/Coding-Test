package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b14391 {
	static int paper[][];
	static int bitMask[];
	static int n;
	static int m;
	
	public static int findScore() {
		
		int result = 0; // 최대값이 저장 될 변수
		
		// 비트 마스크 사용 (겹치지 않는 모든 경우를 체크할 수 있습니다.)
		// 0을 가로, 1을 세로로 판단 
		// n X m 배열을 n * m길이의 비트로 표현 
		for (int i = 0; i < 1<<(n * m); i++) {
			
			int totalScore = 0; // 종이를 나누고 나온 숫자들을 전부 더할 변수
			
			int sum = 0; // 연속된 가로 숫자를 합해서 표현해 줄 변수 
			int row = 0; // 행을 표현해 줄 변수
			
			// 가로(행 고정, 열 증가)
			for (int j = 0; j < n; j++) {
				
				sum = 0;	
				row = j * m; // 행이 증가할 때마다 열의 개수(m)만큼 비트 자리수가 증가
				

				for (int k = 0; k < m; k++) { // 행이 증가한 만큼의 비트 자리수 + 열 == [행][열]
					if((i & 1<<(row + k)) == 0) { 
						sum *= 10; // 2차원 배열에는 한 자리의 수만 들어가 있기 때문에 연속될 때마다 먼저 연산한 숫자에 10을 곱해줍니다.
						sum += paper[j][k];
					}
					else { // 연속이 끊기면 totalScore에 저장해주고 sum을 누적하고 sum을 0으로 만듭니다.(연속이 끊겼기 때문)
						totalScore += sum;
						sum = 0;
					}
				}
				totalScore += sum;
			}
			
			// 세로(열 고정, 행 증가)
			for (int j = 0; j < m; j++) {
				sum = 0; 
				
				for (int k = 0; k < n; k++) {
					row = k * m;
					if((i & 1<<(row+j)) > 0) {
						sum *= 10;
						sum += paper[k][j];
					}
					else {
						totalScore += sum;
						sum = 0;
					}
				}
				totalScore += sum;
			}
			
			if(totalScore > result)
				result = totalScore;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			paper = new int[n][m];
			bitMask = new int[n];
			
			for (int i = 0; i < n; i++) {
				nums = br.readLine();
				for (int j = 0; j < m; j++)
					paper[i][j] = nums.charAt(j) - 48;
			}
			
			System.out.println(findScore());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

