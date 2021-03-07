package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1058 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			StringTokenizer stk = new StringTokenizer(strNums);
			List<Boolean> nums = new ArrayList<Boolean>();
			
			while(stk.hasMoreTokens())
			{
				int intNum = Integer.parseInt(stk.nextToken());
				
				if (intNum != 1 && intNum!= 0)
					return;
				
				boolean num = intNum != 0;
				// java는 boolean에 true를 입력하지 않으면 전부 false로 받아 들이는 것 같습니다.
				// 그렇기 때문에 문자열에서 boolean으로 바로 변환하지 않고 정수형으로 변환 후 (1 != 0)의 결과 true false를 이용해 boolean에 값을 넣습니다.
				nums.add(num);
			}
				
			int result;
			if (!nums.get(0) && !nums.get(1))
				result = 1;
			else
				result = 0;
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
