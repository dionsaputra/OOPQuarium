import java.util.Random;

public class MakananIkan extends ObjekMati {

  private final int kecepatanMakananIkan =1;
  private final int minHargaMakananIkan =20;
  private final int maxHargaMakananIkan =50;
  private int harga;

  public MakananIkan() {
    super(1);//kecepatanMakananIkan
    Random random = new Random();
    harga = random.nextInt(maxHargaMakananIkan - minHargaMakananIkan + 1) + minHargaMakananIkan;
    jenis = "Makanan Ikan";
  }

  public MakananIkan(Point _posisi) {
    super(1);//kecepatanMakananIkan
    harga = random.nextInt(maxHargaMakananIkan - minHargaMakananIkan + 1) + minHargaMakananIkan;
    jenis = "Makanan Ikan";
    posisi = _posisi;
  }

  public int getHarga() {
    return harga;
  }

  public void setHarga(int _harga) {
    harga = _harga;
  }
}
