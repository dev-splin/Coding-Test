package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4256 {
	static StringBuilder sb = new StringBuilder();

	// post(후위) 구하기
	public static void postorder(int pre[], int in[]) {
		// 트리의 길이 구하기
		int length = pre.length;
		
		if(length == 0)
			return;

		// pre의 맨 앞은 Root
		int root = pre[0];
		
		int left = 0;

		// in에서 Root 찾기, Root까지의 개수가 왼쪽의 개수(left) -> 배열이 0부터 시작하기 때문
		for (int i = 0; i < length; i++)
			if(in[i] == root) {
				left = i;
				break;
			}

		// Left
		// left가 0이 아닐 때만, 재귀(left가 0이면 왼쪽이 없다는 의미이기 때문)
		// 구한 left 개수로 배열을 잘라서 재귀 함수를 진행
		if(left != 0)
			postorder(slice(pre, 1, left), slice(in, 0, left-1));

		// Right
		// length - left - 1 은 오른쪽을 의미(전체 크기 - 왼쪽 크기 - 1(루트))
		// 구한 left 개수로 배열을 잘라서 재귀 함수를 진행
		if(length - left -1 != 0)
			postorder(slice(pre, left+1, length-1), slice(in, left+1, length-1));

		// Root 출력
		sb.append(root).append(' ');
	}

	// 배열 자르기
	public static int[] slice(int arr[], int start, int end) {
		int result[] = new int[end-start+1];
		
		int index = 0;
		
		for (int i = start; i <= end; i++) {
			result[index] = arr[i];
			++index;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				
				int pre[] = new int[n];
				int in[] = new int[n];
				
				StringTokenizer preStk = new StringTokenizer(br.readLine());
				StringTokenizer inStk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					pre[j] = Integer.parseInt(preStk.nextToken());
					in[j] = Integer.parseInt(inStk.nextToken());
				}
				
				postorder(pre, in);
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
