// Class representing Rute entity
class Rute {
    private int id;
    private String asal;
    private String tujuan;
    private double jarak;
    public Rute(int id, String asal, String tujuan, double jarak) {
        this.id = id;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jarak = jarak;
    }
    public int getId() { return id; }
    public String getAsal() { return asal; }
    public String getTujuan() { return tujuan; }
    public double getJarak() { return jarak; }
    public String info() {
        return String.format("ID: %d | Rute: %s -> %s | Jarak: %.1f km", id, asal, tujuan, jarak);
    }
}
