package Navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n7576 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static int tomato[][];
	static boolean check[][];
	static int n,m;
	
	// n,m�� �Է¹ް� n��m���� �丶�� �迭�� ����ϴ�. 
	// �� ��, ���δ� �;��ִ� ���� ��, 0�� ���� �丶��迭���� üũ���ְ� boolean�� �����մϴ�.  
	public static boolean makeTomatoBox() throws Exception{
		String nums = br.readLine().trim();
		StringTokenizer stk = new StringTokenizer(nums);
		
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		
		tomato = new int[n][m];
		check = new boolean[n][m];
		
		boolean checkZero = false;
		
		// ��(n)��ŭ �ݺ��ϰ� ��(m)��ŭ �Է��մϴ�. �̶� 0�� �ϳ��� ������ checkZero�� true�� �˴ϴ�.
		for (int i = 0; i < tomato.length; i++) {
			nums = br.readLine().trim();
			stk = new StringTokenizer(nums);
			
			int j = 0;
			while(stk.hasMoreTokens()) {
				tomato[i][j] = Integer.parseInt(stk.nextToken());
				
				if(tomato[i][j] == 0)
					checkZero = true;
				
				++j;
			}
		}
		return checkZero;
	}
	
	// BFS�� �̿��� ������ �ö󰡸� �ش� ��,���� ���� ���� ���� ��,���� �� + 1�� ���ݴϴ�.
	// ���� ���, ó�� ���� �丶�� ���� ������ �丶����� ���� 2�� �Ǵ� ���Դϴ�.
	// �̷��� �Ǹ� �ش� �࿭�� ������ �� ���� ������ ���� �� �ִ����� ��Ÿ�� �� �ֽ��ϴ�.
	// �� ��, ó������ �;��ִ� �丶�䰡 ���� �� ���� �� �ֱ� ������ ó�� ť�� �;��ִ� �丶�� ���θ� �ְ� �����մϴ�.
	public static void BFS() {
		// ��,��,��,��
		int dirRow[] = {-1, 1, 0, 0};
		int dirCol[] = {0, 0, -1, 1};
		
		Queue<Integer> rowQueue = new LinkedList<>();
		Queue<Integer> colQueue = new LinkedList<>();
		
		// 1(�;��ִ� �丶Ʈ)��ġ�� ��� ã�� ť�� �־��ݴϴ�.
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if(tomato[i][j] == 1) {
					rowQueue.add(i);
					colQueue.add(j);
					check[i][j] = true;
				}
			}
		}
		
		while(!rowQueue.isEmpty()) {
			int row = rowQueue.poll();
			int col = colQueue.poll();
			
			for (int i = 0; i < dirRow.length; i++) {
				int tmpRow = row + dirRow[i];
				int tmpCol = col + dirCol[i];
				
				if(tmpRow >= 0 && tmpCol >= 0
					&& tmpRow < n && tmpCol <m)
					if(!check[tmpRow][tmpCol] && tomato[tmpRow][tmpCol] != -1) {
						rowQueue.add(tmpRow);
						colQueue.add(tmpCol);
						
						tomato[tmpRow][tmpCol] = tomato[row][col] + 1;
						check[tmpRow][tmpCol] = true;
					}
			}
		}
	}
	
	public static void main(String[] args) {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			boolean checkZero = makeTomatoBox();
			
			// ó�� ���� ���� �;��ִ� ���� (0�� ������) 0�� ������ְ� ���α׷� �����մϴ�.
			if(!checkZero) {
				bw.write("0");
				bw.flush();
				bw.close();
				return;
			}
			
			BFS();
			
			int day = 0;
			checkZero = false;
			
			// BFS�� ��ġ�� �丶�並 ���� �˻��� �ϳ��� 0(���� ���� �丶��)�� ������ �Ǹ� -1�� ����ϰ�
			// �ƴϸ� �ش� ��,���� ��(���� ��)�� ����ϴµ�, ó�� ������ 1�̹Ƿ� -1 ���ݴϴ�.
			// (���������� ó�� ���� �丶�� ���� ���� 1�� ǥ���ϱ� ����)
			for (int i = 0; i < tomato.length; i++) {
				for (int j = 0; j < tomato[i].length; j++) {
					if(tomato[i][j] == 0)
						checkZero = true;
					
					else if(tomato[i][j] > day)
						day = tomato[i][j];
				}
			}
			
			if(checkZero)
				bw.write("-1");
			else
				bw.write(Integer.toString(day-1));
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
