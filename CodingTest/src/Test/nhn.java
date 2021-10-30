package Test;

import java.io.*;
import java.util.*;
import java.lang.*;

class nhn {
	
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int n = Integer.parseInt(br.readLine()); // 송수신 기록의 수 
		String[] logs = new String[n]; // 송수신 기록
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i ++)
		{
			logs[i] = br.readLine();
		}
		
		int count = 1;
		
		for (int i = 1; i < n; i++) {
			
			if(logs[i].equals(logs[i-1])) {
				++count;
			} else {
				if(count == 1)
					list.add(logs[i-1]);
				else {
					list.add(logs[i-1] + " (" + count + ")");
					count = 1;
				}
			}
		}
		
		if(count == 1)
			list.add(logs[n-1]);
		else
			list.add(logs[n-1] + " (" + count + ")");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(list.size());
		
		for(String str : list) {
			sb.append(str).append('\n');
		}
		
		System.out.println(sb.toString());		
		
	}
}
