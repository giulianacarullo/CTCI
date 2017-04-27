package chapt8;
/**
 * Write a method to generate the nth Fibonacci number. 
 * 
 * This class provides a two solutions for the fibonacci problem:
 *    1) iterative
 *    2) recursive
 * Recursive:
 * Base:
 *  Fib(0) = 0;
 *  Fib(1) = 1;
 *  Fib(2) = 1;
 * Recursion:
 *  Fib (n) = Fib(n-1) + Fib(n-2) for each n>2
 * 
 * @author giulianacarullo
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		for(int i = 0; i< 15; i++)
			System.out.println("Rico-Fibo(" + i + ") = " + fibRecursive(i));
		for(int i = 0; i< 15; i++)
			System.out.println("Iterative-Fibo(" + i + ") = " + fibRecursive(i));
		
	}
	
	public static int fibRecursive(int n) {
		if(n == 0)
			return 0;
		if(n == 1 || n == 2)
			return 1;
		return fibRecursive(n-1) + fibRecursive(n-2);
	}
	
	public static int fibIterative(int n) {
		int prepre;
		int pre;
		int fibo;
		if(n == 0)
			return 0;
		else if(n == 1 || n == 2) 
			return 1;
		else {
			prepre = 1;
			pre = 1;
			for (int i = 3; i < n; i++) {
				fibo = prepre + pre;
				prepre = pre;
				pre = fibo;
			}
			return pre;
		}
	}

}
