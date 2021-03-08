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
			
			// n��ŭ �� ���� ��ġ�� �Է� �ް� �ش� ��ġ�� �� ������ ǥ���� �ݴϴ�.
			for (int i = 1; i <= n; ++i) {
				String nums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(nums);
				
				// �� ���� �ԷµȰ� �ƴϸ� ���α׷��� �����մϴ�.
				if(stk.countTokens() != 2)
					return;
				
				// ��ū���� ���ڸ� ������ x,y�� �ֽ��ϴ�.
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				
				// ���� ó���� ������ 1 1 �̶�� �Է��ϱ� ������ �迭�� ������ �� -1�� �ݴϴ�.
				goBoard[x-1][y-1] = 1;
			}
			
			// �ٵ����� ũ�Ⱑ ������ �ֱ� ������ 19�� �־��ݴϴ�.
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

