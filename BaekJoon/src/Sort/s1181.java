package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class s1181 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			String words[] = new String[n];
			
			for (int i = 0; i < n; i++) 
				words[i] = br.readLine();
			
			Arrays.sort(words,(a,b)-> {
				
				if(a.length() == b.length())
					return a.compareTo(b);
				else
					return a.length() - b.length();
			});
			
			for (int i = 0; i < n ; i++) {
				if(i > 0 && words[i].equals(words[i-1])) 
					continue;
				
				bw.write(words[i]);
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
