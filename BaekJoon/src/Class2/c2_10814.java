package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c2_10814 {
	public static class Person {
		int age;
		String name;
		int rank;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			Person persons[] = new Person[n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				Person person = new Person();
				person.age = Integer.parseInt(stk.nextToken());
				person.name = stk.nextToken();
				person.rank = i;
				
				persons[i] = person;
			}
			
			Arrays.sort(persons, (a,b) -> {
				if(a.age == b.age)
					return a.rank - b.rank;
				
				return a.age - b.age;
			});
			
			for(Person person : persons) {
				sb.append(person.age + " ");
				sb.append(person.name + "\n");
			}
			
			System.out.println(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
