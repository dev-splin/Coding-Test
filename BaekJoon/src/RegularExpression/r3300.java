package RegularExpression;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class r3300 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				String regex = br.readLine();
				String result = br.readLine();
				
				regex = "^" + regex + "$";
								
				if(result.matches(regex))
					System.out.println("_");
				else {
					char ch = '!';
					for (char j = 'A'; j <= 'Z'; j++) {
						String newRegex = regex.replace('_', j);
						
						if(result.matches(newRegex)) {
							ch = j;
							break;
						}
					}
					
					System.out.println(ch);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

