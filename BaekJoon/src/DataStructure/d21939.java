package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class d21939 {
	
	public static class Problem {
		int num;
		int grade;
		
		public Problem(int num, int grade) {
			this.num = num;
			this.grade = grade;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + grade;
			result = prime * result + num;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Problem other = (Problem) obj;
			if (grade != other.grade)
				return false;
			if (num != other.num)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			TreeSet<Problem> ts = new TreeSet<>((a,b) -> {
				if(a.grade == b.grade)
					return a.num - b.num;
				return a.grade - b.grade;
			});
			Map<Integer, Integer> problems = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(stk.nextToken());
				int grade = Integer.parseInt(stk.nextToken());
				
				ts.add(new Problem(num, grade));
				problems.put(num, grade);
			}
			
			n = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				String cmd = stk.nextToken();
				int num = Integer.parseInt(stk.nextToken());
				int grade = 0;
				
				switch (cmd) {
				case "recommend" :
					if(num == 1)
						sb.append(ts.last().num).append('\n');
					else
						sb.append(ts.first().num).append('\n');
					break;
				case "add" :
					grade = Integer.parseInt(stk.nextToken());
					ts.add(new Problem(num, grade));
					problems.put(num, grade);
					break;
				case "solved" :
					grade = problems.get(num);
					ts.remove(new Problem(num, grade));
					problems.remove(num);
					break;
				default :
					break;
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
