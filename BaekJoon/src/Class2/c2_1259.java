package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c2_1259 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			while(true) {
				String num = br.readLine();
				
				if(num.charAt(0) == '0')
					break;
				
				boolean check = true;
				for (int i = 0; i < num.length() / 2; i++) {
					int cmpIndex = num.length() - 1 - i;
					if(num.charAt(i) != num.charAt(cmpIndex))
						check = false;
				}
				
				if(!check)
					System.out.println("no");
				else
					System.out.println("yes");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
