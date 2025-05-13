// Class representing Transaksi entity
class Transaksi {
    private int id;
    private int kendaraanId;
    private int ruteId;
    private double total;
    public Transaksi(int id, int kendaraanId, int ruteId, double total) {
        this.id = id;
        this.kendaraanId = kendaraanId;
        this.ruteId = ruteId;
        this.total = total;
    }
    public int getId() { return id; }
    public int getKendaraanId() { return kendaraanId; }
    public int getRuteId() { return ruteId; }
    public double getTotal() { return total; }
}
