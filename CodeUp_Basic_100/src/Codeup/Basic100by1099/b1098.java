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
			// �������� ����,���θ� �Է¹޽��ϴ�.
			String plaidSize = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(plaidSize);
			
			if(stk.countTokens() != 2)
				return;
			
			// ��ū���� ���� �������� ���α���(h)�� �����մϴ�.
			int h = Integer.parseInt(stk.nextToken());
			if(h < 1 || h > 100)
				return;
			
			// ��ū���� ���� �������� ���α���(w)�� �����մϴ�.
			int w = Integer.parseInt(stk.nextToken());
			if(w < 1 || w > 100)
				return;
			
			// w,h�� �������� ����ϴ�. ��,�� �̱� ������ h,w ������ �־����ϴ�.
			int plaid[][] = new int[h][w]; 
			
			// ������ ����(n)�� �Է¹ް� �����մϴ�.
			int n = Integer.parseInt(br.readLine().trim());
			if(n < 1 || n > 10)
				return;
			
			// ������ ������ �Է¹ް� �����ǿ� ������ ��ġ�� 1�� ä���ݴϴ�.
			for (int i = 0; i < n; i++) {
				// ������ ����, ����, ��ǥ�� �Է¹޽��ϴ�.
				String stick = br.readLine().trim();
				stk = new StringTokenizer(stick);
				
				// �Է¹޾Ƽ� ���� ��ū�� ���� 4��(����,����,��ǥx,y)�� �ƴϸ� ���α׷��� �����մϴ�.
				if(stk.countTokens() != 4)
					return;
				
				// ��ū���� ���� ������ ���̸� �����մϴ�.
				int l = Integer.parseInt(stk.nextToken());
				
				// ��ū���� ���� ������ ������ �����մϴ�. (0�� ������, 1�� �Ʒ���)
				int d = Integer.parseInt(stk.nextToken());
				if(d != 0 && d != 1)
					return;
				
				// ��ū���� ���� ������ ��ǥ�� �����մϴ�. 
				int x = Integer.parseInt(stk.nextToken()) - 1;
				// x,y�� -1�� ���־��� ������ 0���� �۰ų� w���� ũ�ų� ���� �� �� �������� ����� ��ǥ�� �������ݴϴ�.
				if(x < 0 || x >= w)
					return;
				int y = Integer.parseInt(stk.nextToken()) - 1;
				if(y < 0 || y >= h)
					return;
				
				// ���⿡ ���� x,y��ǥ�� ������ �� ����
				int plusrow, pluscol = 0;
			
				// ������ 0 �� �������̸� ��(col)�� �����ϰ� ��(row)�� �������� �ʽ��ϴ�.
				if(d == 0) {
					plusrow = 0;
					pluscol = 1;
				}
				else {	// �Ʒ����̸� ��(row)�� �����ϰ� ��(col)�� �������� �ʽ��ϴ�.
					plusrow = 1;
					pluscol = 0;
				}
				
				// ������ ���̸�ŭ �ݺ��ϴµ�, 1���� �������� �ʰ� 0���� �����ϰ� �Ͽ����ϴ�.
				// �� ������ ������ ���� plusX,plusY�� j�� �����ָ� ���̸�ŭ ��ǥ�� ���ϰ� �˴ϴ�.
				// �� ��, 0���� �����ϸ� ó�� ���� ��ǥ�� ������ �ʱ� ������ ó�� ������ǥ���� ǥ���� �� �ְ� �˴ϴ�.
				for (int j = 0; j < l; j++) {
					int finalrow = x + plusrow * j;
					
					// row�� col�� �������� ������ �Ѿ�� �����ϰ� �˴ϴ�.
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

