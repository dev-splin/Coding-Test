package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b21277 {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
		
	static Puzzle puzzles[]; 
	
	public static class Puzzle {
		int n;
		int m;
		int puzzleBoard[][];
	}
	
	// ������ ����� �޼���
	public static Puzzle makePuzzle() throws Exception{
		String nums = br.readLine();
		StringTokenizer stk = new StringTokenizer(nums);
		
		Puzzle puzzle = new Puzzle();
		
		puzzle.n = Integer.parseInt(stk.nextToken());
		puzzle.m = Integer.parseInt(stk.nextToken());
		puzzle.puzzleBoard = new int [puzzle.n+1][puzzle.m+1];
		
		for (int i = 1; i <= puzzle.n; i++) {
			String puzzleNums = br.readLine();
			
			for (int j = 1; j <= puzzleNums.length(); j++)
				puzzle.puzzleBoard[i][j] = Character.getNumericValue(puzzleNums.charAt(j-1));
			
		}
		
		return puzzle;
	}
	
	// ȸ���ϴ� �޼��� ����ü�� �޾� puzzleBoard�� ���� ���ο� �迭�� ����� �ٲ��ݴϴ�.
	public static void rotate(Puzzle puzzle) {
		int n = puzzle.m;
		int m = puzzle.n;
		
		int tmpPuzzleBoard[][] = new int[n + 1][m + 1];
		
		for (int i = 1; i <= puzzle.n; i++) {
			for (int j = 1; j <= puzzle.m; j++) 
				tmpPuzzleBoard[puzzle.m + 1 - j][i] = puzzle.puzzleBoard[i][j];
		}
		
		puzzle.puzzleBoard = tmpPuzzleBoard;
		puzzle.n = n;
		puzzle.m = m;
	}
	
	// ���ڸ� ���ϴ� �޼���
	public static void makeFrame() {
		Puzzle basePuzzle;
		Puzzle cmpPuzzle;
		
		// �� ū ������ ����(base)�� �մϴ�.
		if(puzzles[0].n + puzzles[0].m > puzzles[1].n + puzzles[1].m) {
			basePuzzle = puzzles[0];
			cmpPuzzle = puzzles[1];
		}
		else {
			basePuzzle = puzzles[1];
			cmpPuzzle = puzzles[0];
		}
		
		int size = 3000;
		
		// ȸ���� �� �ִ� ��ŭ �ݺ�
		for (int i = 0; i < 4; i++) {
			rotate(cmpPuzzle);
			
			// (���� ���� + ���� ���� + ���� ����)�� �� ������ ���� ������ �迭�� ���̸� ���մϴ�.
			int lengthN = basePuzzle.n + cmpPuzzle.n * 2;
			int lengthM = basePuzzle.m + cmpPuzzle.m * 2;
			
			Integer baseFrame[][] = new Integer[lengthN + 1][lengthM + 1];
			
			// ������ ����� N�� �ִ��ּ�, M�� �ִ��ּҸ� ������ ����
			int baseMinN = 1000;
			int baseMaxN = 0;
			int baseMinM = 1000;
			int baseMaxM = 0;
			
			// ������ ������ ���ڿ� ��ġ���� �ָ鼭 ������ N�� �ִ��ּ�, M�� �ִ��ּҸ� ���մϴ�.
			for (int j = 1; j <= basePuzzle.n; j++)
				for (int k = 1; k <= basePuzzle.m; k++) {
					baseFrame[j+cmpPuzzle.n][k+cmpPuzzle.m] = basePuzzle.puzzleBoard[j][k];
					
					baseMinN = Math.min(baseMinN, j+cmpPuzzle.n);
					baseMaxN = Math.max(baseMaxN, j+cmpPuzzle.n);
					baseMinM = Math.min(baseMinM, k+cmpPuzzle.m);
					baseMaxM = Math.max(baseMaxM, k+cmpPuzzle.m);
				}
				
			// �� ���ڸ� ��ȸ�ϱ� ���� ����(�� ������ ��ĭ �� �̵��� �� ���)
			int addN = 0;
			int addM = 0;
			
			while(true) {
				
				if(addM + cmpPuzzle.m > lengthM) {
					addM = 0;
					++addN;
				}
				
				if(addN + cmpPuzzle.n > lengthN)
					break;
				
				Integer cmpFrame[][] = new Integer[lengthN + 1][lengthM + 1];
				
				// ������ ���̸� ���ϱ� ���� N�� �ִ��ּ�, M�� �ִ��ּ� (���� ����� �ʱ�ȭ)
				int minN = baseMinN;
				int maxN = baseMaxN;
				int minM = baseMinM;
				int maxM = baseMaxM;
							
				// �񱳾��ڿ� �������� ����鼭 N�� �ִ��ּ�, M�� �ִ��ּҸ� �����մϴ�.
				for (int j = 1; j <= cmpPuzzle.n; j++) 
					for (int k = 1; k <= cmpPuzzle.m; k++) {
						cmpFrame[j+addN][k + addM] = cmpPuzzle.puzzleBoard[j][k];

						minN = Math.min(minN, j+addN);
						maxN = Math.max(maxN, j+addN);
						minM = Math.min(minM, k+addM);
						maxM = Math.max(maxM, k+addM);
					}
				
				// ��ġ���� üũ
				boolean checkOverlap = false;
				
				for (int j = 1 + cmpPuzzle.n; j <= cmpPuzzle.n + basePuzzle.n; j++) {
					for (int k = 1 + cmpPuzzle.m; k <= cmpPuzzle.m + basePuzzle.m; k++) {
							
						// Integer�� ���ڸ� �ʱ�ȭ �߱� ������ null�� ��, ���ڳ��� ���ؼ� ���� �ε����� ���� 1�� ������ ��ġ�� ��
						if(cmpFrame[j][k] != null && baseFrame[j][k] == 1 && cmpFrame[j][k] == 1){
							checkOverlap = true;
							break;
						}
					}
					if(checkOverlap)
						break;
				}
				++addM;
				
				if(checkOverlap) {
					continue;
				}
				
				int finalN = maxN - minN + 1;
				int finalM = maxM - minM + 1;
				
				// N�� M�� ���� ������ �ּҳ��̸� ����
				size = Math.min(size, finalN * finalM);
			}
		}
		System.out.println(size);
	}
		
	public static void main(String[] args) {
		
		try {
			puzzles = new Puzzle[2];
			
			for (int i = 0; i < 2; i++)
				puzzles[i] = makePuzzle();
				
			makeFrame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


