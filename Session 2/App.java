import java.util.Scanner;

/*
 * Let’s create a program that has 2 variables, called num1 and num2. Divide these 2 numbers 
 * and output to the terminal like we did for Hello World
 */
/*My program, I will not be compiled */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Plaese enter a number for num1: ");
        float num1 = scan.nextFloat();
        System.out.print("Plaese enter a number for num2: ");
        float num2 = scan.nextFloat();
        float ans = num1 / num2 ;
        System.out.println(num1 + "\\ / "+num2+" = " + ans);
        scan.close(); //This is extra, just so the compiler doesn't complain.
    }
}
