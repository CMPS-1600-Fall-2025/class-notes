import java.util.InputMismatchException;
import java.util.Scanner;

public class Fib {

    public static void main(String[] args){
        //int n = 2;
        /*
        for(int n = 1; n <= 10; n++) {
            System.out.printf("FIB[%d]: %d\n", n, fib(n));
        }
        */
        Scanner in = new Scanner(System.in);
        System.out.printf("Fibonacci generator\n");
        System.out.printf("Enter Index:");
        try {
            int n = in.nextInt();
            System.out.printf("FIB[%d]: %d\n", n, fib(n));
        } catch (InputMismatchException e) {
            System.out.println("You must enter an int dufus!");
        }
        
    }

    /**
     * 
     * @param n the fibonacci number to return
     * @return the nth fibonacci number
     */
    public static int fib(int n) {
        int a = 1;
        int b = 2;
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 2;
        }
        int c = -1;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
