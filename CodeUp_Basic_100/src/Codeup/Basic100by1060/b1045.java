package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1045 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String Strnums = br.readLine();
			StringTokenizer stk = new StringTokenizer(Strnums);
			
			List<Integer> nums = new ArrayList<Integer>();
			
			while(stk.hasMoreTokens())
			{
				int num = Integer.parseInt(stk.nextToken());
				
				if (num < 0)
					return;
				
				nums.add(num);
			}
			
			int a = nums.get(0);
			int b = nums.get(1);
			double dividedNum = (double)a / (double)b;
			// 가독성을 위해 변수에 저장해놓습니다.
			
			bw.write(Integer.toString(a + b));
			bw.write("\r\n");
			bw.write(Integer.toString(a - b));
			bw.write("\r\n");
			bw.write(Integer.toString(a * b));
			bw.write("\r\n");
			bw.write(Integer.toString(a / b));
			bw.write("\r\n");
			bw.write(Integer.toString(a % b));
			bw.write("\r\n");
			bw.write(String.format("%.2f", dividedNum));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
