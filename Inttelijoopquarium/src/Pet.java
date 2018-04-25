public class Pet implements Comparable, Consumer {

  private static int counter = 0; // banyak objek Pet yang telah diciptakan
  private boolean faceRight;      // true saat arah muka dari pPet adalah kanan
  private int id;                 // id Pet, unik untuk setiap pet
  private int kecepatan;          // kecepatan Pet, arah horizontal
  private int radius;             // radius jangkauan makan dari Pet
  private int totalMoney;         // jumlah total nilai koin yang di makan pet dalam satu iterasi
  private Point posisi;           // posisi Pet

  /**
   * Konstruktor user-define Pet.
   * @param kecepatan kecepatan Pet
   * @param radius jangkauan makan Pet
   * @param posisi posisi Pet saat diciptakan
   */
  public Pet(int kecepatan, int radius, Point posisi) {
    this.faceRight = true;
    this.id = counter++;
    this.kecepatan = kecepatan;
    this.radius = radius;
    this.totalMoney = 0;
    this.posisi = posisi;
  }

  /**
   * getter getter atribut id.
   * @return id in
   */
  public int getId() {
    return id;
  }

  /**
   * getter atribut faceRight.
   * @return faceRight boolean
   */
  public boolean getFaceRight() {
    return faceRight;
  }

  /**
   * setter atribut faceRight.
   * @param faceRight nilai faceRight yang baru
   */
  public void setFaceRight(boolean faceRight) {
    this.faceRight = faceRight;
  }

  /**
   * getter atribut radius.
   * @return radius int
   */
  public int getRadius() {
    return radius;
  }

  /**
   * setter atribut radius.
   * @param radius nilai radius baru
   */
  public void setRadius(int radius) {
    this.radius = radius;
  }

  /**
   * getter atribut totalMoney.
   * @return totalMoney int
   */
  public int getTotalMoney() {
    return totalMoney;
  }

  /**
   * setter atribut totalMoney.
   * @param totalMoney nilai totalMoney yang baru
   */
  public void setTotalMoney(int totalMoney) {
    this.totalMoney = totalMoney;
  }

  /**
   * getter atribut posisi.
   * @return posisi Point
   */
  public Point getPosisi() {
    return posisi;
  }

  /**
   * setter atribut posisi.
   * @param posisi nilai posisi yang baru
   */
  public void setPosisi(Point posisi) {
    this.posisi = posisi;
  }

  /**
   * pet berjalan dari posisi saat ini ke arah posisi goal sejauh 1 kecepatan.
   * @param goal posisi yang ingin dituju oleh pet saat ini
   */
  public void walkTo(Point goal) {
    int dx = kecepatan;

    if (goal.getAbsis() < posisi.getAbsis()) {
      faceRight = false;
      dx = -1 * dx;
    } else if (goal.getAbsis() == posisi.getAbsis()) {
      dx = 0;
    } else {
      faceRight = true;
    }

    Point point = this.getPosisi();
    point.setAbsis(point.getAbsis() + dx);
    this.setPosisi(point);
  }

  /**
   * cek apakah terdapat koin pada aquarium.
   * @param aq aquarium yang ditempati pet saat ini
   * @return true jika ada koin pada aquarium, sebaliknya false
   */
  private boolean existCoin(Aquarium aq) {
    boolean existCoin = false;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++) {
      if (aq.getListObjekMati().get(i).getJenis().equals("Koin")) {
        existCoin = true; 
        break;
      }
    }
    return existCoin;
  }

  /**
   * cek apakah terdapat koin di bagian dasar aquarium.
   * prekondisi: terdapat koin pada aquarium
   * @param aq aquarium yang ditempati pet saat ini
   * @return true jika ada koin pada bagian dasar aquarium, sebaliknya false
   */
  private boolean existCoinOnGround(Aquarium aq) {
    boolean existCoinOnGround = false;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++) {
      boolean isKoin = aq.getListObjekMati().get(i).getJenis().equals("Koin");
      boolean isDasar = aq.getListObjekMati().get(i).isDasar(aq);
      if (isKoin && isDasar) {
        existCoinOnGround = true;
        break;
      }
    }
    return existCoinOnGround;
  }

  /**
   * mendapatkan indeks linkedlist dari koin terdekat terhadap pet secara horizontal.
   * prekondisi: terdapat koin pada akuarium
   * @param aq aquarium yang ditempati pet saaat ini
   * @return indeks linkedlist dari koin terdekat secara horizontal, int
   */
  private int nearestHorizontalKoin(Aquarium aq) {
    double dist = 1000000;
    int idx = 0;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++) {
      if (aq.getListObjekMati().get(i).getJenis().equals("Koin")) {
        int ordinatObjMati = aq.getListObjekMati().get(i).getPosisi().getOrdinat();
        int absisObjMati = aq.getListObjekMati().get(i).getPosisi().getAbsis();
        if (ordinatObjMati == this.getPosisi().getOrdinat()) {
          if (Math.abs(absisObjMati - this.getPosisi().getAbsis()) < dist) {
            dist = Math.abs(absisObjMati - this.getPosisi().getAbsis());
            idx = i;
          }
        }
      }
    }
    return idx;
  }

  /**
   * mendapatkan indeks linkedlist dari koin terdekat ke bagian dasar akuarium.
   * prekondisi: terdapat koin pada akuarium
   * @param aq aquarium yang ditempati pet saat ini
   * @return indeks linkedlist dari koin terdekat secara vertikal
   */
  private int nearestVerticalKoin(Aquarium aq) {
    double dist = 1000000;
    int idx = 0;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++) {
      if (aq.getListObjekMati().get(i).getJenis().equals("Koin")) {
        int ordinatObjMati = aq.getListObjekMati().get(i).getPosisi().getOrdinat();
        if (Math.abs(ordinatObjMati - this.getPosisi().getOrdinat()) < dist) {
          dist = Math.abs(ordinatObjMati - this.getPosisi().getOrdinat());
          idx = i;
        }  
      }
    }
    return idx;
  }

  /**
   * cek apakah koin idx berada dalam radius Pet.
   * @param aq aquarium yang ditempati pet saat ini
   * @param idx indeks dari koin idx pada linkedlist
   * @return true jika koin idx berada dalam radius Pet
   */
  private boolean isInRadius(Aquarium aq, int idx) {
    Point posisiObjMati = aq.getListObjekMati().get(idx).getPosisi();
    return this.getPosisi().hitungJarak(posisiObjMati) <= radius;
  }

  /**
   * cek apakah koin idx memiliki absis yang berada di dalam radius Pet.
   * @param aq aquarium yang ditempati pet saat ini
   * @param idx indeks dari koin idx pada linkedlist
   * @return true jika absi koin idx berada dalam radius pet
   */
  private boolean isAbsisInRadius(Aquarium aq, int idx) {
    int absisObjMati = aq.getListObjekMati().get(idx).getPosisi().getAbsis();
    return Math.abs(this.getPosisi().getAbsis() - absisObjMati) <= radius / 2;
  }

  /**
   * pet memakan koin idx pada akuarium.
   * @param aq aquarium yang ditempati pet saat ini
   * @param idx indeks dari koin idx pada linkedlist
   */
  public void eat(Aquarium aq, int idx) {
    Koin koin = (Koin) aq.getListObjekMati().get(idx);
    setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
    aq.removeObject(aq.getListObjekMati().get(idx));
  }

  /**
   * seluruh aksi yang dapat dilakukan oleh pet.
   * @param aq aquarium yang ditempati pet saat ini
   */
  public void life(Aquarium aq) {
    if (existCoin(aq)) {
      if (existCoinOnGround(aq)) {
        int idx = nearestHorizontalKoin(aq);
        if (isInRadius(aq,idx)) {
          eat(aq,idx);
        } else {
          walkTo(aq.getListObjekMati().get(idx).getPosisi());
        }
      } else {
        int idx = nearestVerticalKoin(aq);
        if (isInRadius(aq,idx)) {
          eat(aq,idx);
        } else {
          if (!isAbsisInRadius(aq,idx)) {
            walkTo(aq.getListObjekMati().get(idx).getPosisi());
          }
        }
      }
    } 
  }

  /**
   * cek apakah this.pet sama dengan pet pada parameter.
   * @param pet pet yang menjadi objek uji
   * @return 0 jika pet uji merupakan objek pet pembanding, sebaliknya 1
   */
  public int compareTo(Object pet) {
    Pet p = (Pet) pet;
    if (p.getId() == id) {
      return 0;
    } else {
      return 1;
    }
  }
}
