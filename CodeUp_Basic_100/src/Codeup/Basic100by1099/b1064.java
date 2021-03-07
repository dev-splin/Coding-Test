package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1064 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNums = br.readLine();
			StringTokenizer stk = new StringTokenizer(strNums);
			List<Integer> nums = new ArrayList<Integer>();
			
			while(stk.hasMoreTokens())
			{
				int num = Integer.parseInt(stk.nextToken());
				
				nums.add(num);
			}
				
			int firstSmallNum = nums.get(0) > nums.get(1) ? nums.get(1) : nums.get(0);
			// 0번 값과 1번 값을 비교해서 더 작은 값을 가져옵니다.
			int result = firstSmallNum > nums.get(2) ? nums.get(2) : firstSmallNum;
			// 위에 비교한 더 작은값과 2번 숫자를 비교해서 제일 작은 값을 가져옵니다.
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
