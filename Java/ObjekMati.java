public class ObjekMati {

  private static int counter = 0;
  private final int id;
  private int kecepatan;
  private Point posisi;
  private String jenis;

  public ObjekMati(int kecepatan) {
    this.id = counter++;
    this.jenis = null;
    this.kecepatan = kecepatan;
    this.posisi = new Point();
  }

  public int getId() {
    return id;
  }

  public int getKecepatan() {
    return kecepatan;
  }

  public void setKecepatan(int kecepatan) {
    this.kecepatan = kecepatan;
  }

  public String getJenis() {
    return jenis;
  }

  public void setJenis(String jenis) {
    this.jenis = jenis;
  }

  public Point getPosisi() {
    return posisi;
  }

  public void setPosisi(Point posisi) {
    this.posisi = posisi;
  }

  public boolean isDasar(Aquarium aquarium) {
    return this.getPosisi().getOrdinat() >= aquarium.getLength();
  }

  public void turun(Aquarium aquarium) {
    if (!isDasar(aquarium)) {
      Point point = this.getPosisi();
      point.setOrdinat(this.getPosisi().getOrdinat() + this.getKecepatan());
      this.setPosisi(point);
    } else {
      if (this.getJenis() == "Makanan Ikan") {
        aquarium.RemoveObject(this);
      }
    }
  }
}
