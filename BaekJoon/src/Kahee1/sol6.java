package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class sol6 {
	static int n;
	static int c;
	static ArrayList<Integer> cards[];
	static ArrayList<String> cmds[];
	static TreeSet<String> resultSet;
	static int counts[];
	static int resultIndex[];
	static int cmdSeq[];
	static boolean check[];
	
	public static void solve(int num) {
		if(num > n) {
			int cardCounts[] = new int[n+1];
			
			for (int i = 1; i <= c; i++) {
				int index = resultIndex[i];
				cmdSeq[i] = cards[index].get(cardCounts[index]++);
			}
			
			runCard();
			return;
		}
		
		if(counts[num] == 0) {
			solve(num+1);
		} else {
			--counts[num];
			for (int i = 1; i <= c; i++) {
				if(resultIndex[i] == 0) {
					resultIndex[i] = num;
					solve(num);
					resultIndex[i] = 0;
				}
			}
			++counts[num];
		}
	}
	
	public static void runCard() {
		
		String str = "";
		
		for (int i = 1; i <= c; i++) {
			for(String cmd : cmds[cmdSeq[i]]) {
				StringTokenizer stk = new StringTokenizer(cmd);
				
				String text = stk.nextToken();
				
				if(text.equals("ADD"))
					str += stk.nextToken();
				else {
					int index = Integer.parseInt(stk.nextToken());
					
					if(index >= str.length()) {
						resultSet.add("ERROR");
						return;
					}
					
					str = str.substring(0, index) + str.substring(index + 1);
				}
			}
		}
		
		if(str.length() == 0)
			resultSet.add("EMPTY");
		else
			resultSet.add(str);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			
			cards = new ArrayList[n+1];
			cmds = new ArrayList[c+1];
			counts = new int[n+1];
			cmdSeq = new int[c+1];
			resultIndex = new int[c+1];
			resultSet = new TreeSet<>();
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int count = Integer.parseInt(stk.nextToken());
				counts[i] = count;
				
				cards[i] = new ArrayList<>();
				
				for (int j = 1; j <= count; j++)
					cards[i].add(Integer.parseInt(stk.nextToken()));
			}
			
			for (int i = 1; i <= c; i++) {
				stk = new StringTokenizer(br.readLine(), ",");
				
				cmds[i] = new ArrayList<>();
				
				while(stk.hasMoreTokens())
					cmds[i].add(stk.nextToken());
			}
			
			solve(1);
			
			while(!resultSet.isEmpty())
				System.out.println(resultSet.pollFirst());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
