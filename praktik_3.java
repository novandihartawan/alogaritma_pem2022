
import java.util.Scanner;

public class praktik_3 {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.print("x = ");
        int rows = sc.nextInt();

        System.out.println("---- Printing X Pattern ------");

        int k = rows;

        for (int i = 0 ; i < k; i++ )
        {
            for (int j = 0 ; j < k; j++ )
            {
                if(j == i || i + j ==k -1)
                {
                    System.out.print("*");
                }
                else
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}