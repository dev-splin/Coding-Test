package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p9205 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	static int n;
	final static int INF = 3300000;
	// 정점(집 + 편의점 + 페스티벌)을 저장할 배열
	static Node[] stores;
	// 갈 수 있는 경로를 저장할 배열
	static int songdo[][];
	
	// x,y를 저장할 노드 클래스
	public static class Node {
		int x;
		int y;
	}
	
	// 집, 편의점, 페스티벌 장소가 담긴 송도 맵을 만듭니다.
	public static void makeSongdo() throws Exception{
		
		n = Integer.parseInt(br.readLine());
		
		songdo = new int[n+2][n+2];
		
		// 편의점 + 집 + 페스티벌 장소이기 때문에 n+2
		stores = new Node[n+2];
		
		for (int i = 0; i <= n+1; i++) {
			String position = br.readLine();
			StringTokenizer stk = new StringTokenizer(position);
			
			Node node = new Node();
			
			node.x = Integer.parseInt(stk.nextToken());
			node.y = Integer.parseInt(stk.nextToken());
			
			stores[i] = node; 
		}
		
		// 송도맵을 순회해서 거리가 1000이하 즉, 맥주를 50미터 씩 20번 마실 수 있는 거리면 이동할 수 있으므로 1을 없으면 INF를 넣어줍니다.
		// j=i+1을 해준 이유를 예를 들어 설명하자면, i=0,j=1일 때, [0][1],[1][0]값 둘 다 바꿔주기 때문에 i=1,j=0인 경우는 확인하지 않아도 됩니다.
		for (int i = 0; i <= n+1; i++) {
			for (int j = i + 1; j <= n+1; j++) {
				int dist = Math.abs(stores[i].x - stores[j].x) + Math.abs(stores[i].y - stores[j].y);
				
				if(dist <= 1000) {
					songdo[i][j] += 1;
					songdo[j][i] += 1;
				}
				else {
					songdo[i][j] = INF;
					songdo[j][i] = INF;
				}
			}
		}
		
	}
	
	// 페스티벌까지 갈 수 있는지 확인하는 메서드
	public static String goFestival() {
		
		// 플로이드 와샬
		for (int k = 0; k <= n + 1; k++) {
			for (int i = 0; i <= n + 1; i++) {
				for (int j = 0; j <= n + 1; j++) {
					if(songdo[i][j] > songdo[i][k] + songdo[k][j])
						songdo[i][j] = songdo[i][k] + songdo[k][j];
				}
			}
		}
		
		boolean arrivalCheck = false;
		
		// [0][n+1] 즉, 집에서 페스티벌 장소까지 가는 경우가 있는지 체크합니다.
		if(songdo[0][n+1] > 0 && songdo[0][n+1] != INF)
			arrivalCheck = true;
		
		if(arrivalCheck)
			return "happy";
		
		return "sad";
	}
	
	public static void main(String[] args) {
		
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			List<String> list = new ArrayList<>();
			
			for (int i = 0; i < t; i++) {
				makeSongdo();
				
				list.add(goFestival());
			}
			
			for(String result : list) {
				System.out.println(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

