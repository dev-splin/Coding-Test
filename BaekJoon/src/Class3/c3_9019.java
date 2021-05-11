package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_9019 {
	
	public static class Num {
		public int num;
		public String cmd;
		
		public Num(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}
	
	public static int shift(int num, boolean isLeft) {
		if(num == 0)
			return 0;
		
		ArrayDeque<Integer> numDigit = new ArrayDeque<>();
		
		int digit = 0;
		
		while(num != 0 || digit < 4) {
			++digit;
			numDigit.addFirst(num % 10);
			num /= 10;
		}
		
		int moveNum = 0;
		
		if(isLeft) {
			moveNum = numDigit.pollFirst();
			numDigit.addLast(moveNum);
		} else {
			moveNum = numDigit.pollLast();
			numDigit.addFirst(moveNum);
		}
		
		int result = 0;
		
		while(!numDigit.isEmpty()) {
			result *= 10;
			result += numDigit.pollFirst();
		}
		
		return result;
	}
	
	public static Num runCmd(char cmd, Num cur) {
		Num result = new Num(cur.num, cur.cmd);
		
		if(cmd == 'D') {
			result.num *= 2;
			result.num %= 10000;
			result.cmd += 'D';
		} else if(cmd == 'S') {
			if(result.num == 0)
				result.num = 9999;
			else
				result.num -= 1;
			result.cmd += 'S';
		} else if(cmd == 'L') {
			result.num = shift(result.num, true);
			result.cmd += 'L';
		} else {
			result.num = shift(result.num, false);
			result.cmd += 'R';
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(stk.nextToken());
				int end = Integer.parseInt(stk.nextToken());
				
				Queue<Num> q = new LinkedList<>();
				boolean check[] = new boolean[10001];
				
				Num startNum = new Num(start,"");
				
				check[startNum.num] = true;
				q.add(runCmd('D', startNum));
				q.add(runCmd('S', startNum));
				q.add(runCmd('L', startNum));
				q.add(runCmd('R', startNum));
				
				while(!q.isEmpty()) {
					Num cur = q.poll();
					
					if(cur.num == end) {
						sb.append(cur.cmd).append("\n");
						break;
					}
					
					if(check[cur.num])
						continue;
					
					q.add(runCmd('D', cur));
					q.add(runCmd('S', cur));
					q.add(runCmd('L', cur));
					q.add(runCmd('R', cur));
					check[cur.num] = true;
				}
			}
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
