
import java.util.Scanner;

public class TowerOfHanoi {

    static void towerOfHanoi(int n, char source, char spare, char destination) {
        if (n >= 1) {
            towerOfHanoi(n - 1, source, destination, spare);
            System.out.println("Move ring from " + source + " to " + destination);
            towerOfHanoi(n - 1, spare, source, destination);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of rings: ");
        int n = input.nextInt();

        towerOfHanoi(n, 'a', 'b', 'c');
    }
}
