package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class f21278_2 {
	final static int INF = 100000;
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			// �Է� ����
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int buildings[][] = new int[n+1][n+1];
						
			for (int i = 1; i <= m; i++) {
				nums = br.readLine().trim();
				stk = new StringTokenizer(nums);
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				buildings[a][b] = 1;
				buildings[b][a] = 1;
			}
			// �Է� ��
			
			// i == j�� ���(�ڱ��ڽ��� ����Ű�� �ִ� ���� 0�̱� ������)�� �����ϰ� 
			// ���� 0��(��尡 ���������� ���µ��� ����) �ε��� ������ �ִ� ������ �ٲ��ݴϴ�.
			// �ִ� ������ �ٲٴ� ������ �÷��̵� �������� �ּڰ����� ���ϱ� �����Դϴ�.
			for (int i = 1; i < buildings.length; i++)
				for (int j = 1; j < buildings[i].length; j++) 
					if(i != j && buildings[i][j] == 0)
						buildings[i][j] = INF;
			
			// �÷��̵� ������ �����մϴ�.
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i < buildings.length; i++) {
					for (int j = 1; j < buildings.length; j++) {
						if(buildings[i][j] > buildings[i][k] + buildings[k][j])
							buildings[i][j] = buildings[i][k] + buildings[k][j];
					}
				}
			}
			
			int minSum = INF;
			String result = "";
			
			// �� ���� ġŲ���� �����ϰ�(i,j) ��� �ǹ���(k)���� �Ÿ� ���� �� �ּ� ���� ã���ϴ�.
			// "(j,k) + (j,k+1) + j(k+2) ..." �� ��� �ǹ���� �Ÿ� ����
			for (int i = 1; i < buildings.length; i++) {
				for (int j = i+1; j < buildings.length; j++) {
					int sum = 0;
					// �ǹ�(k)���� ġŲ ���� �� ����� ������ ���� ������ (i,k) (j,k) �� �ּ� ���� ���տ� �ֽ��ϴ�.
					for (int k = 1; k < buildings.length; k++) {
						sum += Math.min(buildings[i][k],buildings[j][k]);
					}
					
					if(minSum > sum) {
						minSum = sum;
						result = i + " " + j + " " + minSum * 2;
					}
				}
			}
			System.out.println(result);
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}