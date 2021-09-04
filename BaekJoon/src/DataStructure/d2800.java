package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class d2800 {
	static char[] chars;
	static int length;
	static TreeSet<String> ts = new TreeSet<>();
	static ArrayList<int[]> pairIndexs = new ArrayList<>();
	static int listLength;
	static StringBuilder sb = new StringBuilder();
	
	public static void solve(int index, char[] chs) {
		if(index >= listLength) {
			String result = new String(chs);
			result = result.replaceAll(" ", "");
			ts.add(result);
		} else {
			int[] pair = pairIndexs.get(index);
			
			chs[pair[0]] = ' ';
			chs[pair[1]] = ' ';
			solve(index + 1, chs);
			
			chs[pair[0]] = '(';
			chs[pair[1]] = ')';
			solve(index + 1, chs);
		}
	}
		
	public static void makePair() {
		
		ArrayDeque<Integer> dq = new ArrayDeque<>(); 
		
		for (int i = 0; i < length; i++) {
			if(chars[i] == '(')
				dq.push(i);
			else if(chars[i] == ')') {
				int startPair = dq.pop();
				
				int[] arr = {startPair, i};
				
				pairIndexs.add(arr);
			}
		}
		
		listLength = pairIndexs.size();
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine(); 
			chars = str.toCharArray();
			length = chars.length;
			
			makePair();
			
			solve(0, chars);
			
			for(String result : ts) {
				
				if(result.equals(str))
					continue;
				
				sb.append(result).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
