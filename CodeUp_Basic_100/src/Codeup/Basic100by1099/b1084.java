package Codeup.Basic100by1099;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1084 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine().trim();
			
			//rgb값을 받을 int 배열
			int rgb[] = new int[3];
			
			StringTokenizer stk = new StringTokenizer(nums);
			
			// r,g,b 3개의 값을 받아야 하므로 나눈 문자열이 3개가 안되면 프로그램을 종료합니다.
			if (stk.countTokens() != 3)
				return;
			
			// 값이 3개만 들어오게 했으므로 hasNextTokens()로 체크하지 않고 바로 넣어줍니다.
			rgb[0] = Integer.parseInt(stk.nextToken());
			rgb[1] = Integer.parseInt(stk.nextToken());
			rgb[2] = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < rgb[0]; ++i) {
				for (int j = 0; j < rgb[1]; ++j) {
					for (int k = 0; k < rgb[2]; ++k) {
						bw.write(Integer.toString(i) + " ");
						bw.write(Integer.toString(j) + " ");
						bw.write(Integer.toString(k));
						bw.newLine();
					}
				}
			}
			// rgb 경우의 수 개수
			int count = rgb[0] * rgb[1]  * rgb[2];
			
			bw.write(Integer.toString(count));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
