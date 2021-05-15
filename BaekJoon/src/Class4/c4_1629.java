package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_1629 {
	static long a;
	static long b;
	static long c;
	
	public static long partition(long num) {
		// 지수가 1일 때
		if(num == 1)
			return a % c;
			
		// 재귀를 이용해 분할 정복을 실행 합니다.
		long tmp = partition(num / 2);
		
		// tmp * tmp는 long 자료형 범위를 넘지 않기 때문에 tmp 하나당 % c를 해주지 않아도 됩니다.
		long result = tmp * tmp % c;
		
		// 지수가 홀수 일 때, a를 한번 더 곱해 줍니다. ex) a9 = a4 * a4 * a1
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
