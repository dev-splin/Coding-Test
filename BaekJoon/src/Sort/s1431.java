package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class s1431 {
	
	public static int compareSerial(String serialA, String serialB) {
		
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 0; i < serialA.length(); i++) {
			if(serialA.charAt(i) <= 57)
				sumA += serialA.charAt(i) - 48;
		}
		
		for (int i = 0; i < serialB.length(); i++) {
			if(serialB.charAt(i) <= 57)
				sumB += serialB.charAt(i) - 48;
		}
		
		return sumA - sumB;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			String serials[] = new String[n];
			
			for (int i = 0; i < n; i++)
				serials[i] = br.readLine();
			
			Arrays.sort(serials,(a,b)-> {
				
				if(a.length() == b.length()) {
					int result = compareSerial(a, b);
					if(result == 0)
						return a.compareTo(b);
					else
						return result;
				}
				else
					return a.length() - b.length();
			});
			
			for(String serial : serials) {
				bw.write(serial);
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
