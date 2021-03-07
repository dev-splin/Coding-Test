package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class b1053 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			
			int num = Integer.parseInt(strNums);
			
			if (num != 1 && num != 0)
				return;
			// 입력된 숫자가 1이나 0이 아니면 종료되게 합니다.
			num = Math.abs(num - 1);
			// java에서는 %d를 이용해 정수형에 '!'를 사용할 수 없습니다.
			// 그렇기 때문에 boolean으로 형변환 후 '!' 사용한 다음 다시 Integer로 변환 후 출력하는 방법이 있는데
			// 이 방법은 작업이 많아 질 거 같아 num에서 1을 빼고 절댓값을 이용해 '!'의 역할을 해주었습니다.
			// ex) abs(1 - 1) = 0 / abs(0 - 1) = 1
			
			bw.write(Integer.toString(num));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
