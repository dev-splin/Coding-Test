package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class b1096 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());
			
			int goBoard[][] = new int[19][19]; 
			
			// n만큼 흰 돌의 위치를 입력 받고 해당 위치에 흰돌 유무를 표시해 줍니다.
			for (int i = 1; i <= n; ++i) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				// 두 개가 입력된게 아니면 프로그램을 종료합니다.
				if(stk.countTokens() != 2)
					return;
				
				// 토큰에서 숫자를 가져와 x,y에 넣습니다.
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				
				// 제일 처음의 공간은 1 1 이라고 입력하기 때문에 배열에 저장할 때 -1해 줍니다.
				goBoard[x-1][y-1] = 1;
			}
			
			// 바둑판의 크기가 정해져 있기 때문에 19를 넣어줍니다.
			for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 19; j++) {
					bw.write(Integer.toString(goBoard[i][j]) + " ");
				}
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

