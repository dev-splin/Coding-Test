package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class b21277_2 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	// ������ ������ N�� �ִ��ּ�, M�� �ִ��ּҸ� ������ ����
	static int minBaseN = 1000;
	static int maxBaseN = 0;
	static int minBaseM = 1000;
	static int maxBaseM = 0;
	
	static Set<Point> base;
	static List<Point> cmp;
		
	// �迭�� �ε���(N,M)�� �Ӽ����� ������ ��ü
	// HashSet���� ���� ��ü�� �Ǻ��� �ϱ� ���� hashCode()�� equals()�� �������̵� �մϴ�.
	public static class Point {
		int n;
		int m;
		
		public Point() {}
		public Point(int n, int m) {
			this.n = n;
			this.m = m;
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + n;
			result = prime * result + m;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (n != other.n)
				return false;
			if (m != other.m)
				return false;
			return true;
		}
	}
	
	// ������ ����� �޼���
	public static void makePuzzle() throws Exception{
		String nums = br.readLine();
		StringTokenizer stk = new StringTokenizer(nums);
				
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		base = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			String puzzleNums = br.readLine();
			
			// ���� 1�� �ش��ϴ� ��, ������� ���� ���� ��ü�� ����� �����մϴ�.
			for (int j = 0; j < m; j++) {
				if(puzzleNums.charAt(j) == '1') {
					Point point = new Point(i,j);
					base.add(point);
					minBaseN = Math.min(minBaseN, i);
					maxBaseN = Math.max(maxBaseN, i);
					minBaseM = Math.min(minBaseM, j);
					maxBaseM = Math.max(maxBaseM, j);
				}
			}
		}
		
		nums = br.readLine();
		stk = new StringTokenizer(nums);
				
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		cmp = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String puzzleNums = br.readLine();
			
			for (int j = 0; j < m; j++) {
				if(puzzleNums.charAt(j) == '1') {
					Point point = new Point(i,j);
					cmp.add(point);
				}
			}
		}
	}
	
	
	public static void rotate() {
		int maxM = 0;
		// ArrayList�� �迭ó�� ���� ������� ���̰� ���� ������ M�� �ִ밪�� ã���ݴϴ�.
		for(Point point : cmp) {
			if(maxM < point.m)
				maxM = point.m;
		}
		
		// �����ε����� 0���� ��Ұ�,
		// �迭�� �������� �� ���̰� 3�̸� M�� �ִ밪�� 2�� ������ ������ maxM - point.m�� ������ ȸ���� ������ �� �ְ� �˴ϴ�. 
		// ���� ȸ���ϴ� ������ M-j+1���� -1�� �ϰ� �Ǳ� ����
		for(Point point : cmp) {
			int n = point.n;
			point.n = maxM - point.m;
			point.m = n;
		}
	}
	
	public static void makeFrame() {
		
		int size = 3000;
				
		for (int k = 0; k < 4; k++) {
			
			// -50 ~ 50���� ��ȸ
			for (int i = -50; i < 50; i++) {
				for (int j = -50; j < 50; j++) {
					
					boolean isImpossible = true;
					
					int minN = minBaseN;
					int maxN = maxBaseN;
					int minM = minBaseM;
					int maxM = maxBaseM;
					
					// �� ������ ��ȸ�ϸ鼭 n�� m�� i�� j�� ���� ��ġ �迭�� ������ ���ϴ� ��ó�� �� �� �ֽ��ϴ�.
					for(Point point : cmp) {
						int n = point.n + i;
						int m = point.m + j;
						Point cmpPoint = new Point(n, m);
						
						// ��ü���� n�� m�� �̿��� hashcode�� ����� �־��� ������ n,m ���� ������ ���� ��ü�� �ν��ϰ� �˴ϴ�. 
						if(base.contains(cmpPoint)) {
							isImpossible = false;
							break;
						}
						
						minN = Math.min(minN, n);
						maxN = Math.max(maxN, n);
						minM = Math.min(minM, m);
						maxM = Math.max(maxM, m);
					}
					
					// 1�� ��ġ�� �ʴ� ��Ȳ ��, ������ ��Ȳ�� ����� ���� ���մϴ�.
					if(isImpossible)
						size = Math.min(size, (maxN - minN + 1) * (maxM - minM + 1));
				}
			}
			
			// ȸ��
			rotate();
		}
		
							
		System.out.println(size);
	}
		
	public static void main(String[] args) {
		
		try {
			makePuzzle();
				
			makeFrame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



