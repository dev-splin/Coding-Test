package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class b21277_2 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	// 고정된 퍼즐의 N의 최대최소, M의 최대최소를 저장할 변수
	static int minBaseN = 1000;
	static int maxBaseN = 0;
	static int minBaseM = 1000;
	static int maxBaseM = 0;
	
	static Set<Point> base;
	static List<Point> cmp;
		
	// 배열의 인덱스(N,M)을 속성으로 가지는 객체
	// HashSet에서 같은 객체의 판별을 하기 위해 hashCode()와 equals()를 오버라이딩 합니다.
	public static class Point {
		int n;
		int m;
		
		public Point() {}
		public Point(int n, int m) {
			this.n = n;
			this.m = m;
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + n;
			result = prime * result + m;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (n != other.n)
				return false;
			if (m != other.m)
				return false;
			return true;
		}
	}
	
	// 퍼즐을 만드는 메서드
	public static void makePuzzle() throws Exception{
		String nums = br.readLine();
		StringTokenizer stk = new StringTokenizer(nums);
				
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		base = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			String puzzleNums = br.readLine();
			
			// 값이 1에 해당하는 즉, 비어있지 않은 퍼즐만 객체로 만들어 저장합니다.
			for (int j = 0; j < m; j++) {
				if(puzzleNums.charAt(j) == '1') {
					Point point = new Point(i,j);
					base.add(point);
					minBaseN = Math.min(minBaseN, i);
					maxBaseN = Math.max(maxBaseN, i);
					minBaseM = Math.min(minBaseM, j);
					maxBaseM = Math.max(maxBaseM, j);
				}
			}
		}
		
		nums = br.readLine();
		stk = new StringTokenizer(nums);
				
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		cmp = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String puzzleNums = br.readLine();
			
			for (int j = 0; j < m; j++) {
				if(puzzleNums.charAt(j) == '1') {
					Point point = new Point(i,j);
					cmp.add(point);
				}
			}
		}
	}
	
	
	public static void rotate() {
		int maxM = 0;
		// ArrayList는 배열처럼 따로 행과열의 길이가 없기 때문에 M의 최대값을 찾아줍니다.
		for(Point point : cmp) {
			if(maxM < point.m)
				maxM = point.m;
		}
		
		// 시작인덱스를 0으로 잡았고,
		// 배열로 생각했을 때 길이가 3이면 M의 최대값은 2가 나오기 때문에 maxM - point.m의 값으로 회전을 시켜줄 수 있게 됩니다. 
		// 기존 회전하는 공식인 M-j+1에서 -1을 하게 되기 때문
		for(Point point : cmp) {
			int n = point.n;
			point.n = maxM - point.m;
			point.m = n;
		}
	}
	
	public static void makeFrame() {
		
		int size = 3000;
				
		for (int k = 0; k < 4; k++) {
			
			// -50 ~ 50까지 순회
			for (int i = -50; i < 50; i++) {
				for (int j = -50; j < 50; j++) {
					
					boolean isImpossible = true;
					
					int minN = minBaseN;
					int maxN = maxBaseN;
					int minM = minBaseM;
					int maxM = maxBaseM;
					
					// 비교 퍼즐을 순회하면서 n과 m에 i와 j를 더해 마치 배열을 움직여 비교하는 것처럼 할 수 있습니다.
					for(Point point : cmp) {
						int n = point.n + i;
						int m = point.m + j;
						Point cmpPoint = new Point(n, m);
						
						// 객체에서 n과 m을 이용해 hashcode를 만들어 주었기 때문에 n,m 값이 같으면 같은 객체로 인식하게 됩니다. 
						if(base.contains(cmpPoint)) {
							isImpossible = false;
							break;
						}
						
						minN = Math.min(minN, n);
						maxN = Math.max(maxN, n);
						minM = Math.min(minM, m);
						maxM = Math.max(maxM, m);
					}
					
					// 1이 겹치지 않는 상황 즉, 가능한 상황만 사이즈를 구해 비교합니다.
					if(isImpossible)
						size = Math.min(size, (maxN - minN + 1) * (maxM - minM + 1));
				}
			}
			
			// 회전
			rotate();
		}
		
							
		System.out.println(size);
	}
		
	public static void main(String[] args) {
		
		try {
			makePuzzle();
				
			makeFrame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



