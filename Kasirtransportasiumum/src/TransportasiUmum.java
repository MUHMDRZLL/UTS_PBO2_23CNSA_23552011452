import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    // Interface for transport services
interface TransportasiUmum {
    double hitungBiaya(double jarak);
}

// Base class Kendaraan with encapsulated fields and interface implementation
abstract class Kendaraan implements TransportasiUmum {
    private int id;
    private String jenis;
    private int kapasitas;
    public Kendaraan(int id, String jenis, int kapasitas) {
        this.id = id;
        this.jenis = jenis;
        this.kapasitas = kapasitas;
    }
    public int getId() { return id; }
    public String getJenis() { return jenis; }
    public int getKapasitas() { return kapasitas; }
    public String info() {
        return String.format("ID: %d | Jenis: %s | Kapasitas: %d orang", id, jenis, kapasitas);
    }
      // Abstract method to ensure subclasses provide implementation
    public abstract double hitungBiaya(double jarak);
}