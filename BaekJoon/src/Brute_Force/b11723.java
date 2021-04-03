package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b11723 {
	static OutputStreamWriter osw = new OutputStreamWriter(System.out);
	static BufferedWriter bw = new BufferedWriter(osw);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int s = 0;
			
			for (int i = 0; i < n; i++) {
				String cmd = br.readLine();
				StringTokenizer stk = new StringTokenizer(cmd);
				
				String cmdName = stk.nextToken();

				int x;
				
				switch (cmdName) {
				case "add": 
					x = Integer.parseInt(stk.nextToken());
					s |= (1 << (x-1));
					break;
				case "remove": 
					x = Integer.parseInt(stk.nextToken());
					s &= ( (1 << (x-1)) -1 );
					break;
				case "check": 
					x = Integer.parseInt(stk.nextToken());
					sb.append(((1 << (x-1)) & s) > 0 ? "1\n" : "0\n");
					break;
				case "toggle": 
					x = Integer.parseInt(stk.nextToken());
					s ^= (1 << (x-1));
					break;
				case "all": 
					s = (1 << 20) - 1;
					break;
				case "empty": 
					s = 0;
					break;
				default:
					break;
				}
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

