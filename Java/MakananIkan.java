import java.util.Random;

public class MakananIkan extends ObjekMati {

  private final kecepatanMakananIkan =1;
  private final minHargaMakananIkan =20;
  private final maxHargaMakananIkan =50;
  private int harga;

  public MakananIkan() {
    super(kecepatanMakananIkan);
    Random random = new Random;
    harga = random.nextInt(maxHargaMakananIkan - minHargaMakananIkan + 1) + minHargaMakananIkan;
    jenis = "Makanan Ikan";
  }

  public MakananIkan(Point _posisi) {
    super(kecepatanMakananIkan);
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
