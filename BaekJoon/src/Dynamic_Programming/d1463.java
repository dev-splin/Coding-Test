package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d1463 {
	// memoization
	static Integer memo[];
	
	// memoization(memo �迭)�� �̿��� Top-Down ����Դϴ�.
	// memo�� �ش� �ε����� ���� �� ���ڸ� ������ �� �ִ� �ּڰ� �Դϴ�.
	// �ش� �ε����� ���� ������ ��͸� �̿��� ���� �� �ִ� ����� �� �� �ּ��� ���� ���� �����صӴϴ�. 
	// �ش� �ε����� ���� ������ ����Ǿ��� �ִ� ���� �ҷ� �����ν� ������ ���� ���� �� �ֽ��ϴ�.
	public static int recursive1(int n) {
		
		if(memo[n] == null) {
			// 2�� 3�� �ּҰ������ 6���� ������ ������ ��쿡�� 1�� ���� ���, 3���� ������ ���, 2�� ������ ��찡 ���� ���ֽ��ϴ�.
			// 	
			if(n % 6 == 0) {
				memo[n] = Math.min(recursive1(n-1), Math.min(recursive1(n/3), recursive1(n/2))) + 1;
			} else if(n % 3 == 0) {
				memo[n] = Math.min(recursive1(n/3), recursive1(n-1)) + 1;
			} else if(n % 2 == 0) {
				memo[n] = Math.min(recursive1(n/2), recursive1(n-1)) + 1;
			} else {
				memo[n] = recursive1(n-1) + 1;
			}
		}
				
		// ó�� ��͸� ȣ���� ���� ���� �ִ� �ε����� 1�� 0��(ó���� �ʱ�ȭ)�̹Ƿ�
		// �ε����� 1��, �� ��ǥ�� �����ϰ� �˴ϴ�. �� ��, �ε��� 1�� ���� 0���� ���� �ϸ鼭
		// +1�� ���ϸ鼭 memo[n]�� ��(n�� ����Ǽ� �ּڰ�)�� �����ݴϴ�.(ex) memo[1] = 0, memo[2] = 1)
		// ó�� ��Ϳ��� ���� �ִ� �ε����� �ε��� 1�� 0�������� ��͸� �����Ҽ��� ���� ä������ �ε����� �������� ������ ������ ���� �پ��ϴ�.
		return memo[n];
	}
	
	// memoization�� ������� �ʰ� count�� �����ؼ� ����� �����ݴϴ�.
	// ����ӵ��� ������ �ڵ尡 ���������� �ʾ� ���� �����ϱ� ���� ������ �ֽ��ϴ�.
	public static int recursive2(int n, int count) {
		if(n < 2)
			return count;
		
		// "recursive2(n/2, count + 1 + n % 2)" �� n/2�� ������ �������� ������ ������(n%2)�� count�� �߰��˴ϴ�.
		// ��, n/2�� ������ ������ ������ -1 ���ְ� n/2 ���ִ� �Ͱ� �����ϴ�. 
		// ex) 11 -> 10(11-1, count 1(11%2)����) -> 5(10/2, count 1����) 
		
		// "recursive2(n/3, count + 1 + n % 3)"�� ���������Դϴ�. 
		// ex) 11 -> 10 -> 9(11-1-1, count 2(11%3)����) -> 3(9/3, count1����)
		
		// �̷� ��� �� �ּҰ��� ������ ��츦 ã�� ������ memoization�� ���� �ʰ� ���굵 ª�� ���� ������
		// �ð����⵵, �������⵵ ��� �پ��� ���� �� �� �ֽ��ϴ�.
		return Math.min(recursive2(n/2, count + 1 + n % 2), recursive2(n/3, count + 1 + n % 3));
	}
	
	// Bottom-Up Ǫ�� ����Դϴ�.
	// ��ü memoization�� ��ȸ�ϸ鼭 �ϴ� �ٷ� ���� �ε���(i-1)���� +1�� ���ְ� (i���� i-1�� ������ ������ �ѹ� �ؾ��ϱ� ����)
	// ������ �� i�� 3�̳� 2�� ������ �������� i/3, i/2 �ε����� �ּڰ��� +1�� �� ���� �ְ� �� �� ���� ���� ���� �ε����� ������ �մϴ�. 
	public static void recursive3() {
		
		for (int i = 2; i < memo.length; i++) {
			memo[i] = memo[i-1] +1;
			
			if(i % 3 == 0 && memo[i/3] < memo[i])
				memo[i] = memo[i/3] + 1;
			
			if(i % 2 == 0 && memo[i/2] < memo[i])
				memo[i] = memo[i/2] + 1;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			
			int n = Integer.parseInt(br.readLine().trim());
			
			// memoization�� ����ϱ� ���� �迭�� �ʱ�ȭ ���ְ�
			// 0,1�� �ε����� 0�� �־��ݴϴ�. (1�� �ε������� 1���� ���� ���� 0(�ڱ��ڽ�)�̱� ����, 0�� ��� �ش�X)
			memo = new Integer[n + 1];
			memo[0] = memo[1] = 0;
			
			//recursive1 ����
//			bw.write(Integer.toString(recursive1(n)));
			//recurscive2 ����
//			bw.write(Integer.toString(recursive2(n,0)));	
			
			// recursive3 ����
			recursive3();
			bw.write(Integer.toString(memo[n]));
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
