package project;

import java.util.Scanner;

public class Siakad {
    public static Scanner scan = new Scanner(System.in);
    static project.mahasiswa[] mahasiswa = new mahasiswa[10000];
    static int jumlahData = 0;

    public static void tambahData() {
        System.out.println("Silahkan tambah data \n");
        System.out.print("NIM = ");
        String nim = scan.next();
        scan.nextLine();
        System.out.print("Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;
    }

    public static void tampilData() {
        System.out.println("Berikut data anda: \n");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
            i++;
        }
    }

    public static void main(String[] args) {
        int option;
        Siakad siakad = new Siakad();

        do {
            System.out.println("Menu project.Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu = ");
            option = scan.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    System.out.println("Terimakasih sudah mengunjung siakad");
                    System.exit(0);
            }
            if (option > 3) {
                System.out.println("Input anda tidak sesuai, mohon ulangi lagi. \n");
            }
        } while (option > 0);

    }
}