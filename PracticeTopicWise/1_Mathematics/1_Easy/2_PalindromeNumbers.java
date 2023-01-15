import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int n = input.nextInt();
		
		boolean res = isPalindrome(n);
		System.out.println("The number of digits are: " + res);
		
		input.close();
	}
	
	private static boolean isPalindrome(int n) {
		int rev = 0;
		int temp = n;
		while (n != 0) {
			rev = (rev * 10) + (n % 10);
			n = n/10;
		}
		
		if (temp == rev) {
			return true;
		} else {
			return false;
		}
	}
}

