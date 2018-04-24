public class Koin extends ObjekMati {

  private final int kecepatanKoin = 1;
  private int nilaiKoin;

  public Koin(int nilaiKoin, Point posisi) {
    super(1);
    this.nilaiKoin = nilaiKoin;
    this.jenis = "Koin";
    this.posisi = posisi;
  }

  public int getNilaiKoin() {
    return nilaiKoin;
  }

  public void setNilaiKoin(int nilaiKoin) {
    this.nilaiKoin = nilaiKoin;
  }
}
