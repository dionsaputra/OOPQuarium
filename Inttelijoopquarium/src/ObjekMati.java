import model.Point;

public class ObjekMati implements Comparable {

  protected static int counter = 0;   // counter banyak objekMati yang telah diciptakan
  protected final int id;             // id objekMati, unik untuk setiap objekMati
  protected int kecepatan;            // kecepatan objekMati
  protected Point posisi;             // posisi objekMati
  protected String jenis;             // jenis objekMati [koin, makananIkan]

  /**
   * konstruktor user-define ObjekMati.
   * @param kecepatan kecepatan turun objekMati saat diciptakan
   */
  public ObjekMati(int kecepatan) {
    this.id = counter++;
    this.jenis = null;
    this.kecepatan = kecepatan;
    this.posisi = new Point();
  }

  /**
   * getter atribut Id.
   * @return id objekMati, int
   */
  public int getId() {
    return id;
  }

  /**
   * getter atribut kecepatan.
   * @return kecepatan turun makananIkan, int
   */
  public int getKecepatan() {
    return kecepatan;
  }

  /**
   * setter atribut kecepatan.
   * @param kecepatan nilai kecepatan baru
   */
  public void setKecepatan(int kecepatan) {
    this.kecepatan = kecepatan;
  }

  /**
   * getter atribut jenis.
   * @return jenis, string
   */
  public String getJenis() {
    return jenis;
  }

  /**
   * setter atribut jenis.
   * @param jenis nilai jenis baru
   */
  public void setJenis(String jenis) {
    this.jenis = jenis;
  }

  /**
   * getter atribut posisi.
   * @return posisi objekMati saat ini, point
   */
  public Point getPosisi() {
    return posisi;
  }

  /**
   * setter atribut posisi.
   * @param posisi nilai posisi baru
   */
  public void setPosisi(Point posisi) {
    this.posisi = posisi;
  }

  /**
   * cek apakah objekMati sudah berada di dasar akuarium.
   * @param aquarium akuarium yang ditempati ObjekMati saat ini
   * @return true jika objekMati berada di dasar akuarium, sebaliknya false
   */
  public boolean isDasar(Aquarium aquarium) {
    return this.getPosisi().getY() >= aquarium.getDasar();
  }

  /**
   * untuk turun.
   * @param aquarium aquariumnya
   */
  public void turun(Aquarium aquarium) {
    if (!isDasar(aquarium)) {
      Point pointJava = this.getPosisi();
      pointJava.setY(this.getPosisi().getY() + this.getKecepatan());
      this.setPosisi(pointJava);
    }
  }

  /**
   * membandingkan this objekMati dengan objekMati parameter.
   * @param objekMati objekMati yang menjadi objek pembanding
   * @return 0 jika objekMati parameter merupakan this objekMati, sebaliknya 0
   */
  public int compareTo(Object objekMati) {
    ObjekMati objek = (ObjekMati) objekMati;
    if (objek.getId() == id) {
      return 0;
    } else {
      return 1;
    }
  }
}
