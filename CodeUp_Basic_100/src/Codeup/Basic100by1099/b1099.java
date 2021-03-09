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
			// 10X10�� ����ִ� �̷θ� ����ϴ�.
			int maze[][] = new int[10][10];
			
			// �̷��� ��(������ ����) ��ŭ �ݺ��ؼ� �ش� ���� ���� �Է��� �̷θ� ����ϴ�.
			for (int i = 0; i < maze.length; i++) {
				String colNums = br.readLine().trim();
				StringTokenizer stk = new StringTokenizer(colNums);
				
				// �Էµ� ���� ������ �̷��� ���� �ٸ��� ���α׷��� �����մϴ�.
				if(stk.countTokens() != maze[0].length)
					return;
				
				// ���� ��ȣ�� ��� ����
				int j = 0;
				
				// �������� ��ū�� i�� j���� �ֽ��ϴ�.
				while(stk.hasMoreTokens()) {
					maze[i][j] = Integer.parseInt(stk.nextToken());
					++j;
				}
			}
			
			// ���̰� 2,2(�迭���� 1,1)���� �����ϱ� ������ ������ �࿭�� �������ݴϴ�.
			int antRow = 1;
			int antCol = 1;
			
			// ������ ������ ��� �Ʒ��� ���� ������ �ݴϴ�.
			// �� ��, �������� ���� ���� ���� �ٸ��� ������ ���� ���ϸ� �ǰ�
			// �Ʒ����� ���� ���� �ุ �ٸ��� ������ �ุ �����ݴϴ�.
			int rightCol = antCol + 1;
			
			int bottomRow = antRow + 1;
			
			// ���̰� ����(2)�� ã�ų� ���� ������ �Ʒ��� ������ �� ���� �ݺ��մϴ�.
			while(true) {
				// ������ ��ġ�� 2�� ������ ��ġ�� ǥ�����ְ� �ݺ��� �����մϴ�.
				if(maze[antRow][antCol] == 2) {
					maze[antRow][antCol] = 9;
					break;
				}
				// ���� ������ ��ġ�� ǥ�����ݴϴ�.
				maze[antRow][antCol] = 9;
				
				
				// �����ʰ� �Ʒ��ʿ� �� �� �ִ� ���� ������ ������ �� �Ʒ���� �� �̹Ƿ� �ݺ��� �����մϴ�.
				if(maze[antRow][rightCol] == 1 && maze[bottomRow][antCol] == 1) {
					break;
				}				
				// ���������� �� �� ������(0) ������ ���� ������ ���� �ٲ��ְ� ������ ���� 1�� �����ݴϴ�.
				// "!= 1"�̶�� �� ������ ���̰� ���� ���� �ϴ� �̵����ֱ� �����Դϴ�.
				else if(maze[antRow][rightCol] != 1) {
					antCol = rightCol;
					++rightCol;
				} 
				// �Ʒ������� �� �� ������(0) ������ ���� �Ʒ��� ������ �ٲ��ְ� �Ʒ��� �࿡ 1�� �����ݴϴ�.
				else if(maze[bottomRow][antCol] != 1) {
					antRow = bottomRow;
					++bottomRow;
				}	
			}
			
			// �̷θ� ����մϴ�.
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

