
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KasirTransportasiUmum {
    private final List<Kendaraan> kendaraanDB;
    private final List<Rute> ruteDB;
    private final List<Transaksi> transaksiDB;
    private int transaksiCounter = 1;
     private Scanner scanner = null;
     
 public KasirTransportasiUmum() {
        kendaraanDB = new ArrayList<>();
        ruteDB = new ArrayList<>();
        transaksiDB = new ArrayList<>();
        scanner = new Scanner(System.in);
        
// Sample kendaraan data
        kendaraanDB.add(new Mobil(1, 4));
        kendaraanDB.add(new Mobil(2, 5));
        kendaraanDB.add(new Bus(3, 20));
        kendaraanDB.add(new Bus(4, 40));
        
 // Sample rute data
        ruteDB.add(new Rute(1, "Terminal A", "Terminal B", 10));
        ruteDB.add(new Rute(2, "Terminal A", "Terminal C", 25));
        ruteDB.add(new Rute(3, "Terminal B", "Terminal C", 15));
        ruteDB.add(new Rute(4, "Terminal C", "Terminal D", 30));
 }
 
// Application main loop
    public void run() {
        System.out.println("=== Kasir Sistem Transportasi Umum ===");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Kendaraan");
            System.out.println("2. Tampilkan Rute");
            System.out.println("3. Hitung Biaya Perjalanan dan Simpan Transaksi");
            System.out.println("4. Tampilkan Semua Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
             int pilihan = bacaInt();
            switch (pilihan) {
                case 1 -> tampilkanKendaraan();
                case 2 -> tampilkanRute();
                case 3 -> prosesTransaksi();
                case 4 -> tampilkanTransaksi();
                case 5 -> {
                    System.out.println("Terima kasih. Program selesai.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
     private void tampilkanKendaraan() {
        System.out.println("\n--- Daftar Kendaraan ---");
        for (Kendaraan k : kendaraanDB) {
            System.out.println(k.info());
        }
    }
      private void tampilkanRute() {
        System.out.println("\n--- Daftar Rute ---");
        for (Rute r : ruteDB) {
            System.out.println(r.info());
        }
    }
      private void prosesTransaksi() {
        System.out.println("\n--- Hitung Biaya & Simpan Transaksi ---");
        System.out.println("Pilih Kendaraan (masukkan ID):");
        tampilkanKendaraan();
        int kendaraanId = bacaInt();
        Kendaraan kendaraan = findKendaraanById(kendaraanId);
        if (kendaraan == null) {
            System.out.println("Kendaraan dengan ID tersebut tidak ditemukan.");
            return;
        }
        System.out.println("Pilih Rute (masukkan ID):");
        tampilkanRute();
        int ruteId = bacaInt();
        Rute rute = findRuteById(ruteId);
        if (rute == null) {
            System.out.println("Rute dengan ID tersebut tidak ditemukan.");
            return;
        }
         double totalBiaya = kendaraan.hitungBiaya(rute.getJarak());
        System.out.printf("Total biaya perjalanan: Rp%,.0f%n", totalBiaya);
        transaksiDB.add(new Transaksi(transaksiCounter++, kendaraanId, ruteId, totalBiaya));
        System.out.println("Transaksi berhasil disimpan.");
    }
      private void tampilkanTransaksi() {
        System.out.println("\n--- Semua Transaksi ---");
        if (transaksiDB.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
         for (Transaksi t : transaksiDB) {
            Kendaraan k = findKendaraanById(t.getKendaraanId());
            Rute r = findRuteById(t.getRuteId());
            System.out.printf("ID Transaksi: %d | Kendaraan: %s | Rute: %s → %s | Total: Rp%,.0f%n",
                    t.getId(),
                    (k != null ? k.getJenis() + " (Kapasitas " + k.getKapasitas() + ")" : "Unknown"),
                    (r != null ? r.getAsal() : "Unknown"),
                    (r != null ? r.getTujuan() : "Unknown"),
                    t.getTotal());
        }
    }
      private Kendaraan findKendaraanById(int id) {
        for (Kendaraan k : kendaraanDB) {
            if (k.getId() == id) return k;
        }
        return null;
    }
       private Rute findRuteById(int id) {
        for (Rute r : ruteDB) {
            if (r.getId() == id) return r;
        }
        return null;
    }
       private int bacaInt() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid, masukkan angka: ");
            }
        }
    }
       // Main entry point
    public static void main(String[] args) {
        KasirTransportasiUmum app = new KasirTransportasiUmum();
        app.run();
    }
}