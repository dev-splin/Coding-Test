package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_1629 {
	static long a;
	static long b;
	static long c;
	
	public static long partition(long num) {
		// ������ 1�� ��
		if(num == 1)
			return a % c;
			
		// ��͸� �̿��� ���� ������ ���� �մϴ�.
		long tmp = partition(num / 2);
		
		// tmp * tmp�� long �ڷ��� ������ ���� �ʱ� ������ tmp �ϳ��� % c�� ������ �ʾƵ� �˴ϴ�.
		long result = tmp * tmp % c;
		
		// ������ Ȧ�� �� ��, a�� �ѹ� �� ���� �ݴϴ�. ex) a9 = a4 * a4 * a1
		if(num % 2 == 1) 
			result = result * a % c;
			
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			a = Long.parseLong(stk.nextToken());
			b = Long.parseLong(stk.nextToken());
			c = Long.parseLong(stk.nextToken());
			
			System.out.println(partition(b));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
