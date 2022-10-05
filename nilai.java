package TransaksiPengaturan;
import java.util.Scanner;

public class nilai{
    public static void main(String[] args) {
        String nama;
        int nilai;
        String keterangan;
        Scanner inp = new Scanner(System.in);
        System.out.print("masukan nama : ");
        nama = inp.nextLine();
        System.out.print("masukan nilai : ");
        nilai = inp.nextInt();
        if (nilai >= 60) {
            keterangan = "lulus";
        } else {
            keterangan = "tidak lulus";
        }
        System.out.println("nama : " + nama);
        System.out.println("keterangan : " + keterangan);


    }
}
