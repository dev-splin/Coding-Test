package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.TreeSet;

public class d2800 {
	static char[] chars;
	static int length;
	static TreeSet<String> ts = new TreeSet<>();
	static boolean[] deleteIndexs;
	static StringBuilder sb = new StringBuilder();
	
	public static void solve(int start) {
		ArrayDeque<Integer> dq = new ArrayDeque<>(); 
		
		deleteIndexs = new boolean[length]; 
		
		for (int i = start; i < length; i++) {
			if(chars[i] == '(')
				dq.push(i);
			else if(chars[i] == ')') {
				deleteIndexs[i] = true;
				deleteIndexs[dq.pop()] = true;
				
				String result = makeStr();
				
				if(!ts.contains(result)) {
					ts.add(result);
					sb.append(result).append('\n');
				}
			}
				
		}
	}
	
	public static String makeStr() {
		
		String result = "";
		
		for (int i = 0; i < length; i++) {
			if(deleteIndexs[i])
				continue;
			
			result += chars[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			chars = br.readLine().toCharArray();
			length = chars.length;
			
			for (int i = 0; i < length; i++)
				solve(i);
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
