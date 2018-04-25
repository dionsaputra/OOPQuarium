import java.util.Random;

public class MakananIkan extends ObjekMati {

  private final int kecepatanMakananIkan = 1;
  private final int constHarga = 10;
  private int harga;

  /**
   * konstruktor default makanan ikan.
   */
  public MakananIkan() {
    super(1);
    harga = constHarga;
    jenis = "Makanan Ikan";
  }

  /**
   * konstruktor user-defined makanan ikan.
   * @param posisi posisi makananIkan saat diciptakan
   */
  public MakananIkan(Point posisi) {
    super(1);//kecepatanMakananIkan
    this.harga = constHarga;
    this.jenis = "Makanan Ikan";
    this.posisi = posisi;
  }

  /**
   * getter atribut harga makananIkan.
   * @return harga makananIkan int
   */
  public int getHarga() {
    return this.harga;
  }

  /**
   * setter atribut harga makananIkan
   * @param harga nilai harga baru
   */
  public void setHarga(int harga) {
    this.harga = harga;
  }

  public void turun(Aquarium aq){
    super.turun(aq);
    if (this.isDasar(aq)){
      aq.removeObject(this);
    }
  }
}
