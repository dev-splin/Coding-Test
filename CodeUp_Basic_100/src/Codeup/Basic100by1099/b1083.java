package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1083 {
	
	// 숫자를 받아서 그 숫자에 3,6,9(박수를 칠 숫자)가 몇번 들어 갔는지 찾아주는 함수입니다. 
	public static int clapNum(int num) {
		// 몇 번의 박수가 나오는 지 저장할 변수입니다.
		int clapNum = 0;
	
		// num이 0일 때 까지 반복합니다.
		while(num != 0)
		{
			// 10의 나머지 연산을 이용해 1의 자리수가 3,6,9인지 확인합니다. 
			if(num % 10 == 3 ||
					num % 10 == 6 ||
					 num % 10 == 9) {
					++clapNum;				
			}
			
			// 원래의 숫자를 10씩 나눠주어서 한 자리씩 줄입니다.
			// ex) 3456/10=345, 345/10=34, 34/10= 3
			num /= 10;
		}
				
		return clapNum;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int num = Integer.parseInt(br.readLine().trim());
			// 숫자가 1~9 범위에서 벗어나면 프로그램을 종료합니다.
			if(num < 1 || num > 9)
				return;
			
			for (int i = 1; i <= num; ++i) {
				// 박수의 개수를 구하는 함수를 이용해 박수의 개수를 구합니다.
				int clapNum = clapNum(i);
				
				// 박수의 개수가 0이면 그냥 숫자를 출력해주고 0이 아니면 박수의 개수만큼 X를 출력해줍니다.
				if (clapNum == 0)
					bw.write(Integer.toString(i));
				else {
					for (int j = 1; j <= clapNum; ++j) {
						bw.write('X');
					}
				}
				bw.write(" ");
			}	
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
