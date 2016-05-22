import java.util.Scanner;

public class Fibonacci {
	public static int fibonacci(int n) {
		if (n==0)
				return 0;
		else if (n==1)
			return 1;
		else
			return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main (String args[]) {
		int start = new Scanner(System.in).nextInt();
		int end = new Scanner(System.in).nextInt();

		for (int i=start; i<=end; i++) {
			System.out.println(fibonacci(i));
		}
	}
}
