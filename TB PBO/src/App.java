import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner inputan = new Scanner(System.in);
        String pilih;
        Integer next = 1;
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEEEE, dd/MM/yyyy");
        Date date = new Date();

        Parkir input = new Parkir();
        Login inputl = new Login();

        System.out.println(tanggal.format(date));
        inputl.login();
        
        while (next != 0) {
            System.out.println("+-DATABASE PARKIR NASIONAL-+");
            System.out.println("==============================\n");
            System.out.println("1.\tLihat Data Parkir");
            System.out.println("2.\tTambah Data Parkir");
            System.out.println("3.\tEdit Data Parkir");
            System.out.println("4.\tHapus Data Parkir");
            System.out.println("5.\tPrint Struk Parkir");
            System.out.println("0.\tKeluar");
            System.out.println("==============================\n");

            System.out.print("\nPilih Nomor: ");
            pilih = inputan.next();

            switch (pilih) {
                case "1":
                    System.out.println("\n==============================");
                    System.out.println("        DATA PARKIR      ");
                    System.out.println("==============================");
                    input.dataParkir();
                    break;
                case "2":
                    System.out.println("\n==============================");
                    System.out.println("     TAMBAH DATA PARKIR    ");
                    System.out.println("==============================");
                    input.add();
                    break;
                case "3":
                    System.out.println("\n==============================");
                    System.out.println("     UBAH DATA PARKIR      ");
                    System.out.println("==============================");
                    input.update();
                    break;
                case "4":
                    System.out.println("\n==============================");
                    System.out.println("     HAPUS DATA PARKIR     ");
                    System.out.println("==============================");
                    input.delete();
                    break;
                 case "5":
                    System.out.println("\n==============================");
                    System.out.println("         STRUK PARKIR        ");
                    System.out.println("==============================");
                    input.printStruk();
                    break;    
                case "0":
                    System.out.println("\n==============================");
                    System.out.println("ANDA TELAH KELUAR, SILAHKAN LOGIN KEMBALI");
                    System.out.println("==============================");
                    System.exit(0);
                    break;
                default:
                    System.err.println("\nInput anda tidak ditemukan");

            }
                
            }

        }

}