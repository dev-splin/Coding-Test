package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9663 {
	static int queens[];
	static int n;
	static int count = 0;
	
	// DFS를 이용해 유명상을 판단하여 백 트래킹을 하게 됩니다.
	public static void DFS(int row) {
		
		for (int i = 1; i <= n; i++) {
			// 유망성 판단
			if(checkQueen(row, i)) {
				// 유망성 판단을 통과하고 마지막 행일 경우 count를 올려주고 종료
				if(row == n) {
					++count;
					return;
				}
				
				queens[row] = i;
				DFS(row+1);
			}
		}
	}
	
	// 해당 행,열의 위치가 다른 퀸에게 공격받는 위치인지 확인하는 메서드(유망성 판단)
	public static boolean checkQueen(int row, int col) {
		
		for (int i = 1; i < row; i++)
			if(col == queens[i] || row - i == Math.abs(col - queens[i]))
				return false;
			
		return true;
		
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			queens = new int[n+1];
			DFS(1);
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
