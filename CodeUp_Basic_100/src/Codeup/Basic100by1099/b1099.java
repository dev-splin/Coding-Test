package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class b1099 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// 10X10의 비어있는 미로를 만듭니다.
			int maze[][] = new int[10][10];
			
			// 미로의 행(세로의 길이) 만큼 반복해서 해당 행의 열을 입력해 미로를 만듭니다.
			for (int i = 0; i < maze.length; i++) {
				String colNums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(colNums);
				
				// 입력된 열의 개수가 미로의 열과 다르면 프로그램을 종료합니다.
				if(stk.countTokens() != maze[0].length)
					return;
				
				// 열의 번호를 담는 변수
				int j = 0;
				
				// 나누어진 토큰을 i행 j열에 넣습니다.
				while(stk.hasMoreTokens()) {
					maze[i][j] = Integer.parseInt(stk.nextToken());
					++j;
				}
			}
			
			// 개미가 2,2(배열에선 1,1)에서 시작하기 때문에 개미의 행열을 설정해줍니다.
			int antRow = 1;
			int antCol = 1;
			
			// 개미의 오른쪽 행과 아래쪽 행을 설정해 줍니다.
			// 이 때, 오른쪽은 행은 같고 열만 다르기 때문에 열만 구하면 되고
			// 아래쪽은 열은 같고 행만 다르기 때문에 행만 구해줍니다.
			int rightCol = antCol + 1;
			
			int bottomRow = antRow + 1;
			
			// 개미가 먹이(2)를 찾거나 가장 오른쪽 아래에 도착할 때 까지 반복합니다.
			while(true) {
				// 개미의 위치가 2에 있으면 위치를 표시해주고 반복을 종료합니다.
				if(maze[antRow][antCol] == 2) {
					maze[antRow][antCol] = 9;
					break;
				}
				// 현재 개미의 위치를 표시해줍니다.
				maze[antRow][antCol] = 9;
				
				
				// 오른쪽과 아래쪽에 갈 수 있는 쪽이 없으면 오른쪽 맨 아래라는 뜻 이므로 반복을 종료합니다.
				if(maze[antRow][rightCol] == 1 && maze[bottomRow][antCol] == 1) {
					break;
				}				
				// 오른쪽으로 갈 수 있으면(0) 개미의 열을 오른쪽 열로 바꿔주고 오른쪽 열에 1을 더해줍니다.
				// "!= 1"이라고 준 이유는 먹이가 있을 때도 일단 이동해주기 위함입니다.
				else if(maze[antRow][rightCol] != 1) {
					antCol = rightCol;
					++rightCol;
				} 
				// 아래쪽으로 갈 수 있으면(0) 개미의 행을 아래쪽 행으로 바꿔주고 아래쪽 행에 1을 더해줍니다.
				else if(maze[bottomRow][antCol] != 1) {
					antRow = bottomRow;
					++bottomRow;
				}	
			}
			
			// 미로를 출력합니다.
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					bw.write(Integer.toString(maze[i][j]) + " ");					
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

