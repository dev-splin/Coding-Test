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
	// ����(�� + ������ + �佺Ƽ��)�� ������ �迭
	static Node[] stores;
	// �� �� �ִ� ��θ� ������ �迭
	static int songdo[][];
	
	// x,y�� ������ ��� Ŭ����
	public static class Node {
		int x;
		int y;
	}
	
	// ��, ������, �佺Ƽ�� ��Ұ� ��� �۵� ���� ����ϴ�.
	public static void makeSongdo() throws Exception{
		
		n = Integer.parseInt(br.readLine());
		
		songdo = new int[n+2][n+2];
		
		// ������ + �� + �佺Ƽ�� ����̱� ������ n+2
		stores = new Node[n+2];
		
		for (int i = 0; i <= n+1; i++) {
			String position = br.readLine();
			StringTokenizer stk = new StringTokenizer(position);
			
			Node node = new Node();
			
			node.x = Integer.parseInt(stk.nextToken());
			node.y = Integer.parseInt(stk.nextToken());
			
			stores[i] = node; 
		}
		
		// �۵����� ��ȸ�ؼ� �Ÿ��� 1000���� ��, ���ָ� 50���� �� 20�� ���� �� �ִ� �Ÿ��� �̵��� �� �����Ƿ� 1�� ������ INF�� �־��ݴϴ�.
		// j=i+1�� ���� ������ ���� ��� �������ڸ�, i=0,j=1�� ��, [0][1],[1][0]�� �� �� �ٲ��ֱ� ������ i=1,j=0�� ���� Ȯ������ �ʾƵ� �˴ϴ�.
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
	
	// �佺Ƽ������ �� �� �ִ��� Ȯ���ϴ� �޼���
	public static String goFestival() {
		
		// �÷��̵� �ͼ�
		for (int k = 0; k <= n + 1; k++) {
			for (int i = 0; i <= n + 1; i++) {
				for (int j = 0; j <= n + 1; j++) {
					if(songdo[i][j] > songdo[i][k] + songdo[k][j])
						songdo[i][j] = songdo[i][k] + songdo[k][j];
				}
			}
		}
		
		boolean arrivalCheck = false;
		
		// [0][n+1] ��, ������ �佺Ƽ�� ��ұ��� ���� ��찡 �ִ��� üũ�մϴ�.
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

