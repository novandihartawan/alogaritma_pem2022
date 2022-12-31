import java.util.ArrayList;
import java.util.Scanner;

public class Siakad {
    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static int jumlahData = 0;
    static Scanner scan = new Scanner(System.in);

    //Tambah Data
    public static void tambahData() {
        System.out.println("\n-------------------------------------------");
        System.out.println("|          TAMBAH DATA MAHASISWA          |");
        System.out.println("-------------------------------------------");
        Mahasiswa mahasiswa = new Mahasiswa();
        System.out.println("Silakan tambah data!");
        System.out.print("Masukkan NIM : ");
        String nim = scan.next();
        mahasiswa.setNim(nim);
        System.out.print("Masukkan Nama : ");
        String nama = scan.next();
        System.out.println("\n======================================");
        System.out.println("|          DATA  MAHASISWA           |");
        System.out.println("======================================");
        System.out.println("|     NIM     |         NAMA         |");
        System.out.println("======================================");
        System.out.printf("| %-11s | %-20s |\n", nim, nama);
        System.out.println("--------------------------------------");
        System.out.println("Simpan data mahasiswa?[Y/T]");
        String konf = scan.next();
        scan.nextLine();
        System.out.println("\nMenyimpan data mahasiswa...");
        if (konf.charAt(0) == 'Y' || konf.charAt(0) == 'y') {
            mahasiswa.setNama(nama);
            dataMahasiswa.add(mahasiswa);
            jumlahData= dataMahasiswa.size();
            System.out.println("\nData mahasiswa berhasil disimpan!");
        } else {
            System.out.println("\nGagal menambah data!");
        }
        
    }

    //Lihat Data
    public static void lihatData() {
        System.out.println("\n===========================================");
        System.out.println("|             DATA MAHASISWA              |");
        System.out.println("===========================================");
        System.out.println("| NO |     NIM     |         NAMA         |");
        System.out.println("===========================================");
        if (jumlahData>0){
            for (int i=0; i<jumlahData; i++){
                System.out.printf("| %2d | %-11s | %-20s |\n", (i+1), dataMahasiswa.get(i).getNim(), dataMahasiswa.get(i).getNama());
                System.out.println("-------------------------------------------");
            }
        }else {
            System.out.println("|             Data tidak ada              |");
            System.out.println("-------------------------------------------");
        }
        
    }

    //Urutkan Data
    public static void urutkanData(){
        int pilih;
        do{
            System.out.println("\n================================");
            System.out.println("|  PILIH ALGORITMA PENGURUTAN  |");
            System.out.println("================================");
            System.out.println("| 1 | Exchange Sort            |");
            System.out.println("| 2 | Selection Sort           |");
            System.out.println("| 3 | Bubble Sort              |");
            System.out.println("| 4 | Quick Sort               |");
            System.out.println("| 5 | Shell Sort               |");
            System.out.println("| 6 | Batal                    |");
            System.out.println("================================");
            System.out.print("Pilih algoritma = ");
            pilih = scan.nextInt();
            switch (pilih) {
                case 1: {
                    exchangeSort();
                    break;
                }
                case 2: {
                    selectionsort();
                    break;
                }
                case 3: {
                    bubblesort();
                    break;
                }
                case 4: {
                    System.out.println("\nMemproses Quick Sort...");
                    quickSort(dataMahasiswa, 0, jumlahData-1);
                    System.out.println("\nQuick Sort sukses!");
                    break;
                }
                case 5: {
                    shellsort();
                    break;
                }
                case 6: {
                    main(null);
                }
                default: {
                    System.out.println("\nPilihan tidak sesuai");
                }
            }
        }while (pilih <1 || pilih >6);
    }

    //SORTING ALGORITHM

    //EXCHANGE SORT
    public static void exchangeSort() {
        System.out.println("\nMemproses Exchange Sort...");
        for(int i=0; i<jumlahData; i++){
            for(int j=i+1; j<jumlahData; j++){
                if (dataMahasiswa.get(i).getNim().compareTo(dataMahasiswa.get(j).getNim())>=1) {
                    swap(dataMahasiswa, j, i);
                }
            }
        }
        System.out.println("\nExchange Sort sukses!");
    }

    //SELECTION SORT
    public static void selectionsort() {
        System.out.println("\nMemproses Selection Sort...");
        for(int i=0; i<jumlahData-1; i++){
            int min = i;
            for (int j =i+1; j<jumlahData; j++){
                if (dataMahasiswa.get(j).getNim().compareTo(dataMahasiswa.get(min).getNim())<=-1){
                    min = j;
                }
            }
            swap(dataMahasiswa, min, i);
        }
        System.out.println("\nSelection Sort sukses!");
    }

    //BUBBLE SORT
    public static void bubblesort() {
        System.out.println("\nMemproses Bubble Sort...");
        for (int i=0; i<(jumlahData-1); i++){
            for (int j=0; j<(jumlahData-i-1); j++){
                if(dataMahasiswa.get(j).getNim().compareTo(dataMahasiswa.get(j+1).getNim())>=1){
                    swap(dataMahasiswa, j, j+1);
                }
            }
        }
        System.out.println("\nBubble Sort sukses!");
    }

    //QUICK SORT
    public static void quickSort(ArrayList<Mahasiswa> dataList, int low, int high){
        if(low < high){
            int p = partition(dataList, low, high);
            quickSort(dataList, low, p-1);
            quickSort(dataList, p+1, high);
        }
    }

    static int partition(ArrayList<Mahasiswa> dataList, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(dataList.get(j).getNim().compareTo(dataList.get(low).getNim())<=-1)
                swap(dataList, ++p, j);
    
        swap(dataList, low, p);
        return p;
    }

    //SHELL SORT
    public static void shellsort() {
        System.out.println("\nMemproses Shell Sort...");
        for (int gap=jumlahData/2; gap>0; gap/=2){
            for(int i=gap; i<jumlahData; i++){
                Mahasiswa temp = dataMahasiswa.get(i);
                int j;
                for (j=i; j>=gap &&dataMahasiswa.get(j-gap).getNim().compareTo(temp.getNim())>=1; j--){
                    dataMahasiswa.set(j, dataMahasiswa.get(j-gap));
                }
                dataMahasiswa.set(j, temp);
            }
        }
        System.out.println("\nShell Sort sukses!");
    }

    //swap method
    static void swap(ArrayList<Mahasiswa> dataList, int low, int pivot){
        Mahasiswa temp = dataList.get(low);
        dataList.set(low, dataList.get(pivot));
        dataList.set(pivot, temp);
    }

    
    
    //Cari Data
    public static void cariData() {
        int pilihan;
        do{
            System.out.println("\n-------------------------------------------");
            System.out.println("|            CARI DATA MAHASISWA          |");
            System.out.println("-------------------------------------------");
            System.out.println("|  1  | Linier Search                     |");    
            System.out.println("|  2  | Binary Search                     |");
            System.out.println("|  3  | Batal                             |");
            System.out.println("-------------------------------------------\n");
            System.out.print("Pilih : ");
            pilihan = scan.nextInt();
            switch(pilihan){
                case 1: {
                    caridataLinier();
                    break;
                }
                case 2: {
                    caridataBinary();
                    break;
                }
                case 3: {
                    main(null);
                }
                default: {
                        System.out.println("\nPilihan tidak sesuai");
                }
            }
        }while (pilihan<1 || pilihan>3);
        
    }

    //LINIER SEARCH
    public static void caridataLinier() {
        System.out.println("\n-------------------------------------");
        System.out.println("|            Linier Search          |");
        System.out.println("-------------------------------------\n");
        System.out.print("Masukan NIM : ");
        String nim = scan.next();
        System.out.println("\nMencari data mahasiswa dengan NIM \"" + nim + "\"...");
        int index= linierSearch(dataMahasiswa, nim);
        if (index != -1){
            System.out.println("\nData ditemukan!");
            System.out.println("\n===========================================");
            System.out.println("|             DATA MAHASISWA              |");
            System.out.println("===========================================");
            System.out.println("| NO |     NIM     |         NAMA         |");
            System.out.println("===========================================");
            System.out.printf("| %2d | %-11s | %-20s |\n", (index+1), dataMahasiswa.get(index).getNim(), dataMahasiswa.get(index).getNama());
            System.out.println("-------------------------------------------");
        }else {
            System.out.println("\nData tidak ditemukan!");
        }
    }

    public static int linierSearch(ArrayList<Mahasiswa> dataList, String nim) {
        for (int i= 0; i<jumlahData; i++){
            if(nim.equals(dataList.get(i).getNim())){
                return i;
            }
        }
        return -1;
    }


    //BINARY SEARCH
    public static void caridataBinary() {
        System.out.println("\n-------------------------------------");
        System.out.println("|            Binary Search          |");
        System.out.println("-------------------------------------\n");
        System.out.print("Masukan NIM : ");
        String nim = scan.next();
        System.out.println("\nMencari data mahasiswa dengan NIM \"" + nim + "\"...");
        int index= binarySearch(dataMahasiswa, nim);
        if (index != -1){
            System.out.println("\nData ditemukan!");
            System.out.println("\n===========================================");
            System.out.println("|             DATA MAHASISWA              |");
            System.out.println("===========================================");
            System.out.println("| NO |     NIM     |         NAMA         |");
            System.out.println("===========================================");
            System.out.printf("| %2d | %-11s | %-20s |\n", (index+1), dataMahasiswa.get(index).getNim(), dataMahasiswa.get(index).getNama());
            System.out.println("-------------------------------------------");
        }else {
            System.out.println("\nData tidak ditemukan!");
        }
    }

    public static int binarySearch(ArrayList<Mahasiswa> dataList, String nim) {
        quickSort(dataList, 0, jumlahData-1);
        int x=0, y=jumlahData-1;
        while (x<=y){
            int z = x+(y-1)/2;
            if (dataList.get(z).getNim().equals(nim)){
                return z;
            }

            if (Integer.parseInt(dataList.get(z).getNim()) < Integer.parseInt(nim)){
                x=z+1;
            }else{
                y=z-1;
            }
        }
        return -1;
        
    }

    //Edit Data
    public static void editData() {
        System.out.println("\n-------------------------------------------");
        System.out.println("|           EDIT DATA MAHASISWA           |");
        System.out.println("-------------------------------------------\n");
        lihatData();
        System.out.print("\nMasukan nomor data yang ingin diedit : ");
        int data = scan.nextInt();
        System.out.println("\n===========================================");
        System.out.println("|           EDIT DATA MAHASISWA           |");
        System.out.println("===========================================");
        System.out.println("| NO |     NIM     |         NAMA         |");
        System.out.println("===========================================");
        System.out.printf("| %2d | %-11s | %-20s |\n", (data), dataMahasiswa.get(data-1).getNim(), dataMahasiswa.get(data-1).getNama());
        System.out.println("-------------------------------------------");
        System.out.print("\nMasukkan NIM baru : ");
        String nim = scan.next();
        scan.nextLine();
        System.out.print("Masukkan nama baru : ");
        String nama = scan.nextLine();
        System.out.println("Simpan perubahan?[Y/T]");
        String konf = scan.next();
        
        if (konf.charAt(0) == 'Y' || konf.charAt(0) == 'y') {
            dataMahasiswa.get(data-1).setNim(nim);
            dataMahasiswa.get(data-1).setNama(nama);
            System.out.println("\nEdit data berhasil!");
        } else {
            System.out.println("\nEdit data gagal!");
            main(null);
        }

    }

    //Hapus Data
    public static void hapusData() {
        System.out.println("\n-------------------------------------------");
        System.out.println("|           HAPUS DATA MAHASISWA          |");
        System.out.println("-------------------------------------------");
        System.out.println("|  1  | Hapus data tertentu               |");    
        System.out.println("|  2  | Hapus seluruh data                |");
        System.out.println("-------------------------------------------\n");
        System.out.print("Pilih : ");
        int pilih = scan.nextInt();
        switch (pilih) {
            case 1: {
                delData();
                break;
            }
            case 2:{
                delAllData();
                break;
            }
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
    }

    //Hapus data tertentu
    public static void delData() {
        System.out.println("\n-------------------------------------------");
        System.out.println("|           HAPUS DATA MAHASISWA          |");
        System.out.println("-------------------------------------------\n");
        lihatData();
        System.out.print("\nMasukan nomor data yang ingin dihapus : ");
        int hapus = scan.nextInt();
        System.out.println("Yakin hapus data dengan nim \"" + dataMahasiswa.get(hapus-1).getNim() + "\"" + " atas nama \"" +dataMahasiswa.get(hapus-1).getNama() + "\"?[Y/T]");
            String konf = scan.next();
            if (konf.charAt(0) == 'Y' || konf.charAt(0) == 'y') {
                dataMahasiswa.remove(hapus-1);
                jumlahData= dataMahasiswa.size();
                System.out.println("Hapus data berhasil!");
            } else {
                System.out.println("Hapus data gagal!");
                main(null);
            }
    }

    //Hapus seluruh data
    public static void delAllData() {
        System.out.println("\n-------------------------------------------");
        System.out.println("|           HAPUS DATA MAHASISWA          |");
        System.out.println("-------------------------------------------");
        lihatData();
        System.out.println("\nYakin hapus semua data?[Y/T]");
        String konf = scan.next();
        if (konf.charAt(0) == 'Y' || konf.charAt(0) == 'y') {
            dataMahasiswa.clear();
            jumlahData= dataMahasiswa.size();
            System.out.println("Berhasil Menghapus Semua Data");
        } else {
            System.out.println("Gagal Menghapus Data");
            main(null);
        }
        
    }


    //UAS
    public static void uas() {
        if (jumlahData==0){
            System.out.println("Kosong");
        }else {
            int jarak = jumlahData;
            int susut = 13;
            int urut =  0;
            while(urut == 0){
                jarak = (jarak*10)/susut;
                if (jarak <=1){
                    jarak=1;
                    urut=1;
                }
                for (int i=0; i+jarak<jumlahData; i++){
                    if (dataMahasiswa.get(i).getNim().compareTo(dataMahasiswa.get(+jarak).getNim())>0){
                        swap(dataMahasiswa, i, i+jarak);
                        urut =0;
                    }
                }
            }
            System.out.println("Data Sukses Diurutkan. Silahkan tampilkan data.");
        }
        
    }


    public static void main(String [] args) {
        int menu;
        do {
            System.out.println("\n========================");
            System.out.println("|     MENU SIAKAD      |");
            System.out.println("========================");
            System.out.println("| 1 | Tambah Data      |");
            System.out.println("| 2 | Lihat Data       |");
            System.out.println("| 3 | Urutkan Data     |");
            System.out.println("| 4 | Cari Data        |");
            System.out.println("| 5 | Edit Data        |");
            System.out.println("| 6 | Hapus Data       |");
            System.out.println("| 7 | UAS              |");
            System.out.println("| 8 | Keluar           |");
            System.out.println("========================");
            System.out.print("Pilih menu : ");
            menu = scan.nextInt();

            if (menu==1){
                tambahData();
            }else if (menu==2){
                lihatData();
            }else if (menu==3){
                urutkanData();
            }else if (menu==4){
                cariData();
            }else if (menu==5){
                editData();
            }else if (menu==6){
                hapusData();
            }else if (menu==7){
                uas();
            }

        }while(menu!=8);
        System.out.println("\nKeluar dari program siakad...");
        System.out.println("\nBerhasil keluar! \nTerima kasih!:D\n");
    }
}
