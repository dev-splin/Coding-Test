package RegularExpression;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class r2671 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine();
			Pattern p = Pattern.compile("(100+1+|01)+");
			Matcher m = p.matcher(str);
			
			if(m.matches())
				System.out.println("SUBMARINE");
			else
				System.out.println("NOISE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
