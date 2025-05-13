// Subclass Mobil that extends Kendaraan and overrides hitungBiaya()
class Mobil extends Kendaraan {
    public Mobil(int id, int kapasitas) {
        super(id, "Mobil", kapasitas);
    }
    @Override
    public double hitungBiaya(double jarak) {
        // Tarif per km untuk mobil dengan diskon faktor kapasitas maks 4
        int maxDiscountCapacity = 4;
        int factor = Math.min(this.getKapasitas(), maxDiscountCapacity);
        return 1000 * jarak * (factor / (double)maxDiscountCapacity);
    }
}
    

