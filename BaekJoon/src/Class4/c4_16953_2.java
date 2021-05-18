package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_16953_2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			// 입력 시작
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			// 입력 끝
			
			int ans = 1;
			
			// b -> a로 가기 때문에 b가 같거나 작아지는 순간 종료합니다.
			while(b > a) {
                // 숫자 b를 문자열로 만들어 줍니다.
				String tmp = "" + b;
				
				// 마지막 자리 숫자가 1이면 문자열을 잘라서 1을 빼줍니다.
				if(tmp.charAt(tmp.length()-1) == '1') {
					b = Integer.parseInt(tmp.substring(0, tmp.length()-1));
					++ans;
				// 짝수면 2로 나눌 수 있기 때문에 2로 나눕니다.
				} else if(b % 2 == 0) {
					b >>= 1;
					++ans;
				// 두 조건 모두 충족할 수 없고, b가 a에 도달하지 못했다면 성립할 수 없는 숫자입니다.
				} else
					break;
			}
			
			if(b != a)
				ans = -1;
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
