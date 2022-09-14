import java.util.Scanner;

public class pemjumlahan {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan Nilai x : ");
        x = inp.nextInt();
        System.out.print("Masukkan Nilai y : ");
        y = inp.nextInt();

        int hasil = x + y;

        System.out.print("hasil = " + hasil);


    }
}
