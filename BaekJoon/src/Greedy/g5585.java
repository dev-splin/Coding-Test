package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class g5585 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int changeType[] = {500,100,50,10,5,1};
			int buyMoney = Integer.parseInt(br.readLine().trim());
			int change = 1000 - buyMoney;
			int count = 0;
			
			for (int i = 0; i < changeType.length; i++) {
				count += change / changeType[i];
				change %= changeType[i];
				if(change == 0)
					break;
			}
			
			bw.write(Integer.toString(count));
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
