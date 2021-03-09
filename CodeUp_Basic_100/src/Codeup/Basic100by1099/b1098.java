package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class b1098 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// 격자판의 가로,세로를 입력받습니다.
			String plaidSize = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(plaidSize);
			
			if(stk.countTokens() != 2)
				return;
			
			// 토큰으로 나눈 격자판의 세로길이(h)를 저장합니다.
			int h = Integer.parseInt(stk.nextToken());
			if(h < 1 || h > 100)
				return;
			
			// 토큰으로 나눈 격자판의 가로길이(w)를 저장합니다.
			int w = Integer.parseInt(stk.nextToken());
			if(w < 1 || w > 100)
				return;
			
			// w,h로 격자판을 만듭니다. 행,렬 이기 때문에 h,w 순으로 넣었습니다.
			int plaid[][] = new int[h][w]; 
			
			// 막대의 개수(n)을 입력받고 저장합니다.
			int n = Integer.parseInt(br.readLine().trim());
			if(n < 1 || n > 10)
				return;
			
			// 막대의 정보를 입력받고 격자판에 막대의 위치에 1을 채워줍니다.
			for (int i = 0; i < n; i++) {
				// 막대의 길이, 방향, 좌표를 입력받습니다.
				String stick = br.readLine().trim();
				stk = new StringTokenizer(stick);
				
				// 입력받아서 나눈 토큰의 수가 4개(길이,방향,좌표x,y)가 아니면 프로그램을 종료합니다.
				if(stk.countTokens() != 4)
					return;
				
				// 토큰으로 나눈 막대의 길이를 저장합니다.
				int l = Integer.parseInt(stk.nextToken());
				
				// 토큰으로 나눈 막대의 방향을 저장합니다. (0은 오른쪽, 1은 아래쪽)
				int d = Integer.parseInt(stk.nextToken());
				if(d != 0 && d != 1)
					return;
				
				// 토큰으로 나눈 막대의 좌표를 저장합니다. 
				int x = Integer.parseInt(stk.nextToken()) - 1;
				// x,y에 -1을 해주었기 때문에 0보다 작거나 w보다 크거나 같을 때 즉 격자판을 벗어나는 좌표면 종료해줍니다.
				if(x < 0 || x >= w)
					return;
				int y = Integer.parseInt(stk.nextToken()) - 1;
				if(y < 0 || y >= h)
					return;
				
				// 방향에 따라 x,y좌표에 연산을 할 변수
				int plusrow, pluscol = 0;
			
				// 방향이 0 즉 오른쪽이면 열(col)만 증가하고 행(row)은 증가하지 않습니다.
				if(d == 0) {
					plusrow = 0;
					pluscol = 1;
				}
				else {	// 아래쪽이면 행(row)만 증가하고 열(col)은 증가하지 않습니다.
					plusrow = 1;
					pluscol = 0;
				}
				
				// 막대의 길이만큼 반복하는데, 1부터 시작하지 않고 0부터 시작하게 하였습니다.
				// 그 이유는 연산할 변수 plusX,plusY에 j를 곱해주면 길이만큼 좌표에 더하게 됩니다.
				// 이 때, 0부터 시작하면 처음 시작 좌표에 더하지 않기 때문에 처음 시작좌표부터 표시할 수 있게 됩니다.
				for (int j = 0; j < l; j++) {
					int finalrow = x + plusrow * j;
					
					// row나 col이 격자판의 범위를 넘어서면 종료하게 됩니다.
					if(finalrow >= h)
						break;
					
					int finalcol = y + pluscol * j;
					if(finalcol >= w)
						break;
					
					plaid[finalrow][finalcol] = 1;
				}
			}
			
			for (int i = 0; i < plaid.length; i++) {
				for (int j = 0; j < plaid[0].length; j++) {
					bw.write(Integer.toString(plaid[i][j]) + " ");
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

