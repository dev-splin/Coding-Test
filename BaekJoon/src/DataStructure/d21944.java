package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class d21944 {
	
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
			
			HashMap<Integer, TreeSet<Problem>> r1 = new HashMap<>();
			
			TreeSet<Problem> r2 = new TreeSet<>((a,b) -> {
				if(a.grade == b.grade)
					return a.num - b.num;
				return a.grade - b.grade;
			});
			
			TreeMap<Integer, TreeSet<Integer>> r3 = new TreeMap<>();
			
			Map<Integer, int[]> problems = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(stk.nextToken());
				int grade = Integer.parseInt(stk.nextToken());
				int type = Integer.parseInt(stk.nextToken());
				
				TreeSet<Problem> ts = r1.getOrDefault(type, new TreeSet<>((a,b) -> {
					if(a.grade == b.grade)
						return a.num - b.num;
					return a.grade - b.grade;
				}));
				
				ts.add(new Problem(num, grade));
				r1.put(type, ts);
				
				r2.add(new Problem(num, grade));
				
				TreeSet<Integer> set = r3.getOrDefault(grade, new TreeSet<>());
				set.add(num);
				r3.put(grade, set);
				
				int arr[] = {grade, type};
				problems.put(num, arr);
			}
			
			n = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				String cmd = stk.nextToken();
				int num1 = Integer.parseInt(stk.nextToken());
				int num2 = 0;
				int num3 = 0;
				
				switch (cmd) {
					case "recommend" :
						num2 = Integer.parseInt(stk.nextToken());
						if(num2 == 1)
							sb.append(r1.get(num1).last().num).append('\n');
						else
							sb.append(r1.get(num1).first().num).append('\n');
						break;
					case "recommend2" :
						if(num1 == 1)
							sb.append(r2.last().num).append('\n');
						else
							sb.append(r2.first().num).append('\n');
						break;
					case "recommend3" :
						num2 = Integer.parseInt(stk.nextToken());
						Integer num = 0;
						if(num1 == 1) {
							num = r3.ceilingKey(num2);
							if(num == null)
								sb.append(-1).append('\n');
							else
								sb.append(r3.get(num).first()).append('\n');	
						} else {
							num = r3.lowerKey(num2);
							if(num == null)
								sb.append(-1).append('\n');
							else
								sb.append(r3.get(num).last()).append('\n');
						}
						break;
					case "add" :
						num2 = Integer.parseInt(stk.nextToken());
						num3 = Integer.parseInt(stk.nextToken());
						
						TreeSet<Problem> ts = r1.getOrDefault(num3, new TreeSet<>((a,b) -> {
							if(a.grade == b.grade)
								return a.num - b.num;
							return a.grade - b.grade;
						}));
						
						ts.add(new Problem(num1, num2));
						r1.put(num3, ts);
						
						r2.add(new Problem(num1, num2));
						
						TreeSet<Integer> set = r3.getOrDefault(num2, new TreeSet<>());
						set.add(num1);
						r3.put(num2, set);
						
						int arr[] = {num2, num3};
						problems.put(num1, arr);
						break;
					case "solved" :
						num2 = problems.get(num1)[0];
						num3 = problems.get(num1)[1];
						
						TreeSet<Problem> r1Ts = r1.get(num3);
						r1Ts.remove(new Problem(num1, num2));
						
						if(r1Ts.isEmpty())
							r1.remove(num3);
						
						r2.remove(new Problem(num1, num2));
						
						TreeSet<Integer> r3Set = r3.get(num2);
						r3Set.remove(num1);
						
						if(r3Set.isEmpty())
							r3.remove(num2);
						
						problems.remove(num1);
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
