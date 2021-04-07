package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9663 {
	static int queens[];
	static int n;
	static int count = 0;
	
	// DFS�� �̿��� ������� �Ǵ��Ͽ� �� Ʈ��ŷ�� �ϰ� �˴ϴ�.
	public static void DFS(int row) {
		
		for (int i = 1; i <= n; i++) {
			// ������ �Ǵ�
			if(checkQueen(row, i)) {
				// ������ �Ǵ��� ����ϰ� ������ ���� ��� count�� �÷��ְ� ����
				if(row == n) {
					++count;
					return;
				}
				
				queens[row] = i;
				DFS(row+1);
			}
		}
	}
	
	// �ش� ��,���� ��ġ�� �ٸ� ������ ���ݹ޴� ��ġ���� Ȯ���ϴ� �޼���(������ �Ǵ�)
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
