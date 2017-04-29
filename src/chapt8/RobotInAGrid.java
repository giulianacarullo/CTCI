package chapt8;

import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down. 
 * How many possible paths are there for the robot?
 * 
 * FOLLOW UP
 * Imagine certain squares are “off limits”, such that the robot can not 
 * step on them Design an algorithm to get all possible paths for the robot. 
 * 
 * 
 * @author giulianacarullo
 *
 */
public class RobotInAGrid {
	public static void main(String[] args) {
		System.out.println("Maze 3x3: "+ maze(3));
		System.out.println("Maze 4x4: "+ maze(4));
		System.out.println("Maze 5x5: "+ maze(5));
		int[][] maze = {{0,0,0},{0,1,1},{0,0,0}};
		boolean found = mazeFollowup(maze, 0, 0, 0, 3);
		System.out.println("found: "+ found);
		for(Point p: paths)
			System.out.println(p.getX() + " - "+p.getY());
	}

	static ArrayList<Point> paths = new ArrayList<Point>();
	/**
	 * 
	 * The idea is that, if the robot is allowed to only move right and down, 
	 * we need to consider all the possible moves (right - down) | (down - right)
	 * into any possible order. 
	 * however if we think the problem as move on x and y axis:
	 *  --------->x 
	 * |
	 * |
	 * |
	 * y
	 * every path requires n-1 steps right, n-1 steps down. Thus, the number of
	 * paths is simply; (n-1)! + (n-1)! which represent - relatively - the 
	 * number of moves on the x axis and the number of moves on the y axis. 
	 * 
	 * @param n
	 * @return
	 */
	public static int maze(int n) {
		return factorial(n-1) + factorial(n-1);
	}
	//internal factorial calc
		private static int factorial(int n) {
	        int fact = 1; 
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }
	/**
	 * 
     * FOLLOW UP
     * Imagine certain squares are “off limits”, such that the robot can not 
     * step on them Design an algorithm to get all possible paths for the robot. 
     * 
     * This problem can be solved using backtracking (like the classical N-Queen
     * problem. 
     * We consider a matrix with all elements as zero, except those not viable 
     * that are set to 1. 
     * 
     * for every element into the cell, we move left or down. if the path is viable,
     * we recurse. otherwise we backtrack of one and continue. 
     * 
     * The base case is when we arrive in the final cell (path found)
     * or when we end up in not being able to perform other moves. 
     * 
     * ps. the current code only finds if a path exists 
     * and computes the first path found. 
     * 
	 * @param n is the dimension of the maze
	 */
	public static boolean mazeFollowup(int[][] maze, int current_path, int i, int j, int n) {
		//base case
		if(i == n-1 && j == n-1) {
			System.out.println("Arrived! yay!");
			return true;
		}
		
		Point c = new Point(i,j);
		paths.add(c); //adding point 
		boolean success = false; 
		if(j+1<n && maze[i][j+1] == 0){ //can move right
			System.out.println("Going right "+ i + " - "+(j+1));
			success = mazeFollowup(maze, current_path, i, j+1, n);
		}
					
		if(!success && i+1<n && maze[i+1][j] == 0) {//can move down		
			success = mazeFollowup(maze, current_path, i+1, j, n);
			System.out.println("Going down "+ (i+1) + " - "+j);
		}
		if(!success)
			paths.remove(c);
		return success;
		
	}
	
	
}
