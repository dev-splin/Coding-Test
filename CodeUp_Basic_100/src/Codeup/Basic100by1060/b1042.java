package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1042 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String strNum = br.readLine();
			
			StringTokenizer stk = new StringTokenizer(strNum);
			
			List<Integer> nums = new ArrayList<Integer>();
			// 정수를 받기 위한 리스트
			
			while (stk.hasMoreTokens()) {
				nums.add(Integer.parseInt(stk.nextToken()));				
			}
			
			int result = nums.get(0) / nums.get(1);
			
			bw.write(Integer.toString(result));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
