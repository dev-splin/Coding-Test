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
			// 19X19�� �ٵ����� ����ϴ�.
			int goBoard[][] = new int[19][19];
			
			// �ٵ����� ���� ������ŭ �ݺ��� ���� �Է¹ް� �����մϴ�.
			for (int i = 0; i < goBoard.length; i++) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				// �Էµ� ���� ������ �ٵ����� ���� ������ �ٸ��� ���α׷��� �����մϴ�.
				if(stk.countTokens() != goBoard[0].length)
					return;
				
				//��� ° ������ �����ϴ� ����
				int j = 0;
				while(stk.hasMoreTokens())
				{
					int num = Integer.parseInt(stk.nextToken());
					goBoard[i][j] = num;
					++j;
				}
			}
			
			// ������ Ƚ��
			int flipNum = Integer.parseInt(br.readLine().trim());
			
			if(flipNum > 10)
				return;
			
			// ������ Ƚ����ŭ �Է¹ް� ���ڵ����⸦ ���ݴϴ�.
			for (int i = 0; i < flipNum; i++) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				// �Էµ� x,y �� 2���� �ƴϸ� ���α׷��� �����մϴ�.
				if(stk.countTokens() != 2)
					return;
				
				// ���� 10,10�� �Է¹޾Ҵٰ� �ϸ� �迭���� ���� �ε����� 9,9 �̱� ������ -1 ���ݴϴ�.
				int x = Integer.parseInt(stk.nextToken()) - 1;
				int y = Integer.parseInt(stk.nextToken()) - 1;
				
				// ���� �����⸦ ���� �ٵ����� ���� ������ŭ �ݺ��� �Է��� y��° ���� �ٲ��ݴϴ�.
				for (int j = 0; j < goBoard.length; j++) {
					if(goBoard[j][y] == 0)
						goBoard[j][y] = 1;
					else
						goBoard[j][y] = 0;
				}
				
				// ���� �����⸦ ���� �ٵ����� ���� ������ŭ �ݺ��� �Է��� x��° ���� �ٲ��ݴϴ�.
				for (int j = 0; j < goBoard[0].length; j++) {
					if(goBoard[x][j] == 0)
						goBoard[x][j] = 1;
					else
						goBoard[x][j] = 0;
				}
			}
			
			// �ٵ����� ������ݴϴ�.
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

