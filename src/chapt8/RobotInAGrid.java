package chapt8;

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
	}
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
	
	/**
	 * TBD
	 * @param n
	 */
	public static void mazeFollowup(int n) {
		
	}
	
	//internal factorial calc
	private static int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
