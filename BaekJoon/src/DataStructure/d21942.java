package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class d21942 {
	
	// 대여기간 초단위로 변환
	public static long convertL(String l) {
		StringTokenizer stk = new StringTokenizer(l,"/");
		
		String day = stk.nextToken();
		String time = stk.nextToken();
		
		long seconds = 0;
		
		seconds += removeFrontZero(day) * (24 * 60);
		
		stk = new StringTokenizer(time, ":");
		
		String hour = stk.nextToken();
		String minute = stk.nextToken();
		
		seconds += removeFrontZero(hour) * 60;
		seconds += removeFrontZero(minute);
		
		return seconds;
	}
	
	// 문자열에서 앞에 0제거 후 숫자로 변환
	public static int removeFrontZero(String numStr) {
		int length = numStr.length();
		int startIndex = 0;
		
		while(startIndex < length && numStr.charAt(startIndex) == '0')
			++startIndex;
		
		if(startIndex < length) {
			numStr = numStr.substring(startIndex);
			return Integer.parseInt(numStr);
		} else
			return 0;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			String l = stk.nextToken();
			int f = Integer.parseInt(stk.nextToken());
			
			long convertL = convertL(l);
			
			HashMap<String, HashMap<String, Long>> map = new HashMap<>();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			TreeMap<String, Long> ts = new TreeMap<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				String date = stk.nextToken() + ' ' + stk.nextToken();
				String item = stk.nextToken();
				String id = stk.nextToken();
				
				long longDate = format.parse(date).getTime() / 60 / 1000;
				HashMap<String, Long> valueMap = null;
				
				if(map.containsKey(id)) {
					valueMap = map.get(id);
					
					if(valueMap.containsKey(item)) {
						long prevTime = valueMap.get(item);
						long resultTime = longDate - prevTime - convertL;
						
						if(resultTime > 0) {
							long price = resultTime * f;
							long priceSum = ts.getOrDefault(id, (long)0);
							priceSum += price;
							ts.put(id, priceSum);
						}
						
						valueMap.remove(item);
					} else {
						valueMap.put(item, longDate);
					}
					
				} else {
					valueMap = new HashMap<>();
					valueMap.put(item, longDate);
					map.put(id, valueMap);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			if(ts.isEmpty())
				System.out.println(-1);
			else {
				while(!ts.isEmpty()) {
					Entry<String, Long> entry = ts.pollFirstEntry();
					sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
				}
				
				System.out.println(sb.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
