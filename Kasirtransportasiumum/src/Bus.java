// Subclass Bus that extends Kendaraan and overrides hitungBiaya()
class Bus extends Kendaraan {
    public Bus(int id, int kapasitas) {
        super(id, "Bus", kapasitas);
    }
    @Override
    public double hitungBiaya(double jarak) {
        // Tarif bus per km lebih tinggi
        return 1500 * jarak;
    }
}
