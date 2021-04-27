package Kakao.Blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class kb2021_6 {
	static class Solution {
		Map<Integer, LinkedList<Point>> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int g_board[][];
		
		class Point {
			int row;
			int col;
			int index;
			
			public Point(int row, int col, int index) {
				this.row = row;
				this.col = col;
				this.index = index;
			}
		}
		
		class Node {
			int row;
			int col;
			int count;
			
			public Node(int row, int col, int count) {
				this.row = row;
				this.col = col;
				this.count = count;
			}
		}
		
	    public int solution(int[][] board, int r, int c) {
	    	
	    	g_board = board;
	    	
	    	setting(board);
	    	
	    	Integer permu[] = new Integer[map.size()];
	    	map.keySet().toArray(permu);
	    	
	    	permutation(permu, 0, r, c);
	    	
	        return min;
	    }
	    
	    public void setting(int[][] board) {
	    	
	    	for (int i = 0; i < board.length; i++) {
	        	for (int j = 0; j < board.length; j++) {
	        		int card = board[i][j];
	        		if(card == 0)
	        			continue;
	        		
	        		Point p = new Point(i,j,card);
	        		
	        		if(map.containsKey(card))
	        			map.get(card).add(p);
	        		else {
	        			LinkedList<Point> list = new LinkedList<>();
	        			list.add(p);
	        			map.put(card, list);
	        		}
				}
			}
	    }
	    
	    public void permutation(Integer[] permu, int depth, int r, int c) {
	    	if(depth == permu.length-1) {
	    		int tmpBoard[][] = copyBoard();
	    		findPuzzle(tmpBoard, permu, r, c, 0, 0);
	    		System.out.println(Arrays.toString(permu));
	    	} else {
		    	for(int i = depth ; i < permu.length; ++i) {
		    		swap(permu, depth, i);
		    		permutation(permu, depth+1, r, c);
		    		swap(permu, depth, i);
		    	}
	    	}
	    }
	    
	    public void swap(Integer[] permu, int a, int b) {
	    	int temp = permu[a];
	    	permu[a] = permu[b];
	    	permu[b] = temp;
	    }
	    
	    public void findPuzzle(int[][] board, Integer[] permu, int r, int c, int index, int count) {
	    	if(count > min)
	    		return;
	    	
	    	if(index >= permu.length) {
	    		min = Math.min(min, count);
	    		return;
	    	}
	    	
	    	Point p1 = map.get(permu[index]).get(0);
	    	Point p2 = map.get(permu[index]).get(1);
	    	
	    	int nextCount;
	    	nextCount = count + getDist(board, r, c, p1, p2);
	    	findPuzzle(board, permu, p2.row, p2.col, index+1, nextCount);
	    	board[p1.row][p1.col] = p1.index;
	    	board[p2.row][p2.col] = p2.index;
	    	
	    	nextCount = count + getDist(board, r, c, p2, p1);
	    	findPuzzle(board, permu, p1.row, p1.col, index+1, nextCount);
	    	board[p1.row][p1.col] = p1.index;
	    	board[p2.row][p2.col] = p2.index;
	    }
	    
	    public int getDist(int[][] board, int startRow, int startCol, Point p1, Point p2) {
	    	int count = 0;
	    	count += moveToPuzzle(board, startRow, startCol, p1.row, p1.col);
	    	count += moveToPuzzle(board, p1.row, p1.col, p2.row, p2.col);
	    	board[p1.row][p1.col] = 0;
	    	board[p2.row][p2.col] = 0;
	    	return count + 2;
	    }
	    
	    public int[][] copyBoard() {
	    	int tmpBoard[][] = new int[4][4];
	    	for (int i = 0; i < 4; i++) 
				for (int j = 0; j < 4; j++)
					tmpBoard[i][j] = g_board[i][j];
	    	
	    	return tmpBoard;
	    }
	    
	    int addRow[] = {-1, 1, 0, 0};
    	int addCol[] = {0, 0, -1, 1};
	    public int moveToPuzzle(int[][] board, int startRow, int startCol, int endRow, int endCol) {
	    	PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.count - b.count);
	    	pq.add(new Node(startRow, startCol, 0));
	    	
	    	boolean visited[][] = new boolean[4][4];
	    	visited[startRow][startCol] = true;
	    	
	    	int count = 0;
	    	
	    	while(!pq.isEmpty()) {
	    		Node cur = pq.poll();
	    		
	    		if(cur.row == endRow && cur.col == endCol) {
	    			count = cur.count;
	    			break;
	    		}
	    		
	    		for (int i = 0; i < addRow.length; i++) {
	    			int row = cur.row;
	    			int col = cur.col;
	    			
	    			while (true) {
	    				row += addRow[i];
	    				col += addCol[i];
	    				
	    				if(row >= 0 && row < 4 && col >= 0 && col < 4) {
	    					if(board[row][col] > 0) {
	    						if(!visited[row][col]) {
	    							pq.add(new Node(row, col, cur.count+1));
	    							visited[row][col] = true;
	    						}
	    						break;
	    					}
	    				} else {
	    					row -= addRow[i];
		    				col -= addCol[i];
		    				
    						if(!visited[row][col]) {
    							pq.add(new Node(row, col, cur.count+1));
    							visited[row][col] = true;
    						}
    						break;
	    				}
					}
	    			
	    			row = cur.row + addRow[i];
    				col = cur.col + addCol[i];
    				
    				if(row >= 0 && row < 4 && col >= 0 && col < 4)
    					if(!visited[row][col]) {
    						pq.add(new Node(row, col, cur.count+1));
    						visited[row][col] = true;
    					}
				}
	    	}
	    	return count;
	    }
	}
	
	public static void main(String[] args) {
		int[][] board = {
                {3,0,0,2},
                {0,0,1,0},
                {0,1,0,0},
                {2,0,0,3}
        };
		
        int r = 0;
        int c = 1;
        
        System.out.println(new Solution().solution(board, r, c));
	}
}
