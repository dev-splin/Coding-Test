package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class b1097 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// 19X19의 바둑판을 만듭니다.
			int goBoard[][] = new int[19][19];
			
			// 바둑판의 행의 개수만큼 반복해 열을 입력받고 저장합니다.
			for (int i = 0; i < goBoard.length; i++) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				// 입력된 열의 개수가 바둑판의 열의 개수와 다르면 프로그램을 종료합니다.
				if(stk.countTokens() != goBoard[0].length)
					return;
				
				//몇번 째 열인지 저장하는 변수
				int j = 0;
				while(stk.hasMoreTokens())
				{
					int num = Integer.parseInt(stk.nextToken());
					goBoard[i][j] = num;
					++j;
				}
			}
			
			// 뒤집기 횟수
			int flipNum = Integer.parseInt(br.readLine().trim());
			
			if(flipNum > 10)
				return;
			
			// 뒤집기 횟수만큼 입력받고 십자뒤집기를 해줍니다.
			for (int i = 0; i < flipNum; i++) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				// 입력된 x,y 가 2개가 아니면 프로그램을 종료합니다.
				if(stk.countTokens() != 2)
					return;
				
				// 만약 10,10을 입력받았다고 하면 배열에서 실제 인덱스는 9,9 이기 때문에 -1 해줍니다.
				int x = Integer.parseInt(stk.nextToken()) - 1;
				int y = Integer.parseInt(stk.nextToken()) - 1;
				
				// 십자 뒤집기를 위해 바둑판의 행의 갯수만큼 반복해 입력한 y번째 열을 바꿔줍니다.
				for (int j = 0; j < goBoard.length; j++) {
					if(goBoard[j][y] == 0)
						goBoard[j][y] = 1;
					else
						goBoard[j][y] = 0;
				}
				
				// 십자 뒤집기를 위해 바둑판의 열의 갯수만큼 반복해 입력한 x번째 행을 바꿔줍니다.
				for (int j = 0; j < goBoard[0].length; j++) {
					if(goBoard[x][j] == 0)
						goBoard[x][j] = 1;
					else
						goBoard[x][j] = 0;
				}
			}
			
			// 바둑판을 출력해줍니다.
			for (int i = 0; i < goBoard.length; i++) {
				for (int j = 0; j < goBoard[0].length; j++) {
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

