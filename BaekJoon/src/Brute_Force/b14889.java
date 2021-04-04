package Brute_Force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b14889 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int s[][] = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				for (int j = 0; j < n; j++)
					s[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			
			for (int i = 1; i < 1 << n; i++) {
				
				if(Integer.bitCount(i) != n / 2)
					continue;
				
				int startTeamAbillity = 0;
				int linkTeamAbillity = 0;
				
				List<Integer> startTeam = new ArrayList<>();
				List<Integer> linkTeam = new ArrayList<>();
				
				for (int j = 0; j < n; j++) { 
					if((i & (1 << j)) > 0)
						startTeam.add(j);
					else
						linkTeam.add(j);
				}
				
				
				for (int member1 : startTeam) 
					for (int member2 : startTeam) 
						startTeamAbillity += s[member1][member2];
				
				for (int member1 : linkTeam) 
					for (int member2 : linkTeam) 
						linkTeamAbillity += s[member1][member2];
				
				int sub = Math.abs(startTeamAbillity-linkTeamAbillity);
				
				if(Math.abs(sub) < min)
					min = sub;
				
				if(min == 0)
					break;
			}
			
			System.out.println(min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

