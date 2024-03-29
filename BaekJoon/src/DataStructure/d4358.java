package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class d4358 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine();
			
			int count = 0;
			TreeMap<String, Integer> treeMap = new TreeMap<>(); 
			
			while(str != null) {
				++count;
				
				int num = treeMap.getOrDefault(str, 0);
				
				treeMap.put(str, num + 1);
				
				str = br.readLine();
			}
			
			for(String key : treeMap.keySet()) {
				float num = ((float)treeMap.get(key) / (float)count) * 100;
				System.out.printf("%s %.4f\n", key, num);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
