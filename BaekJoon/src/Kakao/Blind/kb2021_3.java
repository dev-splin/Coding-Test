package Kakao.Blind;

import java.util.*;

public class kb2021_3 {
	static class Solution{
		StringTokenizer stk;
		Map<String, List<Integer>> map = new HashMap<>();
		
		public int[] solution(String[] info, String[] query) {
			
			makeMap(info);
			
			int[] answer = new int[query.length];
			
			for (int i = 0; i < query.length; i++) {
				answer[i] = find(query[i]);
			}
			
			return answer;
		}
		
		public void makeMap(String[] info) {
			for (int i = 0; i < info.length; i++) {
				DFS(info[i].split(" "), "", 0);
			}
			
			for(List<Integer> list : map.values())
				Collections.sort(list);
		}
		
		public void DFS(String[] info, String key, int depth) {
			
			if(depth == 4) {
				if(!map.containsKey(key)) {
					List<Integer> list = new ArrayList<>();
					list.add(Integer.parseInt(info[depth]));
					map.put(key, list);
				} else
					map.get(key).add(Integer.parseInt(info[depth]));
				
				return;
			}
			
			DFS(info, key + info[depth], depth + 1);
			DFS(info, key + "-", depth + 1);
		}
		
		public int find(String query) {
			
			String key = "";
			
			stk = new StringTokenizer(query);
			
			while(stk.countTokens() > 1) {
				String token = stk.nextToken();
				
				if(token.compareTo("and") == 0)
					continue;
				else
					key += token;
			}
			
			if(!map.containsKey(key))
				return 0;
			
			int score = Integer.parseInt(stk.nextToken());
			
			List<Integer> list = map.get(key);
			
			int start = 0;
			int end = list.size() - 1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(list.get(mid) >= score)
					end = mid - 1;
				else
					start = mid + 1;
			}
			
			return list.size() - start;
		}
	}
	
	public static void main(String[] args) {
		String a[] = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String b[] = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(a, b)));
	}
}
