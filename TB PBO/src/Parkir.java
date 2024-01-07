import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Parkir implements CRUD {
    //Connect Database
    Connection conn;
    String url = "jdbc:mysql://localhost/parkir_nasional";
    String driver = "com.mysql.jdbc.Driver";

    //Properti yang digunakan
    String jenisK;
    String noPlat;
    String noParkir;
    String namaK;

    //Menampilkan data dari database
    public void dataParkir()throws SQLException{
        try{
            String sql = "SELECT * FROM parkir";
            conn = DriverManager.getConnection(url, "root", "");
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);

        //perulangan agar data yang tidak ditampilkan hanya satu
        while (result.next()) {
            System.out.println();
            System.out.println("No Parkir \t: " + result.getString("noParkir"));
            System.out.println("Nama Motor \t: " + result.getString("jenisK"));
            System.out.println("Nama Kendaraan \t: " + result.getString("namaK"));
            System.out.println("No Plat \t: " + result.getString("noPlat"));
        }
        st.close();
    } catch (Exception e){
        System.out.println("GAGAL MENAMPILKAN DATA");
    }
}
//Menambah Data ke Database
public void add() throws SQLException{
    Scanner strg = new Scanner(System.in);  

        System.out.println("Masukkan Nomor Parkir : ");
        noParkir = strg.next();
        System.out.println("Masukkan Jenis Kendaraan : ");
        jenisK = strg.next();
        System.out.println("Masukkan Nama Kendaraan : ");
        namaK = strg.next();
        System.out.println("Masukkan Nomor Plat : ");
        noPlat = strg.next();
    
        //Percabangan yang bergantung pada boolean
            try{
                conn = DriverManager.getConnection(url, "root", "");
                Statement st = conn.createStatement();
                String sql = "INSERT INTO parkir (noParkir, noPlat,jenisK, namaK) VALUES ('"+ noParkir 
                + "','"+ noPlat + "','"+ jenisK + "','"+ namaK + "') ";
                st.execute(sql);    
                System.out.println("DATA BERHASIL DITAMBAHKAN\n");

                } catch (Exception e) {
                    e.printStackTrace();
                    // System.err.println("DATA GAGAL DITAMBAHKAN");
                }
            }
        
        @Override
        //update data pada Database
    public void update() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan No Parkir  yang ingin diubah : ");
        noParkir = scanner.next();
        conn = DriverManager.getConnection(url, "root", "");
        Statement st = conn.createStatement();

        System.out.println("Data yang ingin diubah\n");
        System.out.println("1. Jenis Kendaraan");
        System.out.println("2. Nama Kendaraan");
        System.out.println("3. Data Nomor Plat");

        System.out.println("Pilihan anda : ");
        Scanner terminalInput = new Scanner(System.in);
        Integer PilihanUser = terminalInput.nextInt();

        switch (PilihanUser) {
            case 1:
                System.out.print("Masukkan Jenis Kendaraan : ");
                jenisK = scanner.next();
                String sql = String.format("UPDATE parkir SET jenisK = '%s' WHERE noParkir ='%s'", jenisK,noParkir);
                st.executeUpdate(sql);
                System.out.println("DATA BERHASIL DIUPDATE\n");
                break;
            case 2:
                System.out.print("Masukkan Nama Kendaraan : ");
                namaK = scanner.next();
                 sql = String.format("UPDATE parkir SET namaK = '%s' WHERE noParkir ='%s'", namaK,noParkir);
                st.executeUpdate(sql);
                System.out.println("DATA BERHASIL DIUPDATE\n");
                break;
            case 3:
                System.out.print("Masukkan Nomor Plat : ");
                noPlat = scanner.next();
                 sql = String.format("UPDATE parkir SET noPlat = '%s' WHERE noParkir ='%s'", noPlat,noParkir);
                st.executeUpdate(sql);
                System.out.println("DATA BERHASIL DIUPDATE\n");
                break;
            default:
                System.err.println("\nInput anda tidak ditemukan");
        }
    }
                //hapus data pada Database
    public void delete() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan Nomor Parkir yang ingin dihapus : ");
            noParkir = scanner.next();

            conn = DriverManager.getConnection(url, "root", "");
            String sql = String.format("DELETE FROM parkir WHERE noParkir ='%s'", noParkir);
            Statement st = conn.createStatement();

            st.executeUpdate(sql);
            System.out.println("Berhasil menghapus data parkir dengan No Parkir = " + noParkir);

        } catch (Exception e) {
            System.out.println("No Parkir tidak ada dalam Database");
        }
        
    }


     //print Struk
     public void printStruk(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nomor Parkir yang ingin di Cetak : ");
        noParkir = scanner.next();

        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM parkir WHERE noParkir =?");
            pst.setString(1, noParkir);
            ResultSet result = pst.executeQuery();

            Date date = new Date();
            SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-mm-yy");
            SimpleDateFormat jam =  new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");

            if (result.next()) {
            System.out.println("----------- Parkir Nasional -----------");
            System.out.println(hari.format(date));
            System.out.println(jam.format(date));
            System.out.println("No Parkir \t: " + result.getString("noParkir"));
            System.out.println("====================================");
            System.out.println("---------- DATA PARKIR NASIONAL ----------");
            System.out.println("Jenis Kendaraan \t: " + result.getString("jenisK"));
            System.out.println("Nama Kendaraan \t\t: " + result.getString("namaK"));
            System.out.println("Nomor Plat \t\t: " + result.getString("noPlat"));
            System.out.println("Terimakasih telah parkir di Parkir Nasional");
            }
            else{
                System.out.println("Data tidak ditemukan");
            }
            
        } catch (Exception e) {
            e.printStackTrace();//System.err.println("Data dengan no Parkir " + noParkir + " tidak ditemukan");
        }
        

   
    }
    
}
