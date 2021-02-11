import model.Point;

public class Koin extends ObjekMati {

  private final int kecepatanKoin = 1;
  private int nilaiKoin;

  /**
   * konstruktor user-define koin.
   * @param nilaiKoin nilai koin
   * @param posisi posisi koin pada saat diciptakan
   */
  public Koin(int nilaiKoin, Point posisi) {
    super(1);
    this.nilaiKoin = nilaiKoin;
    this.jenis = "Koin";
    this.posisi = posisi;
  }

  /**
   * getter nilai koin.
   * @return nilai koin integer
   */
  public int getNilaiKoin() {
    return nilaiKoin;
  }

  /**
   * setter nilai koin.
   * @param nilaiKoin nilai nilaiKoin baru
   */
  public void setNilaiKoin(int nilaiKoin) {
    this.nilaiKoin = nilaiKoin;
  }
}
