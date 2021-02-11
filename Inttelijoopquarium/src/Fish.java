import java.util.Random;
import model.Entity;
import model.Point;

public abstract class Fish implements Comparable, Entity {

  protected static int counter = 0;
  private final double pi = 3.14159265;
  protected int maxStarving;
  protected int maxStarvationPeriod;
  protected int maxMoveTime;
  protected int id;
  protected boolean rightDirect;
  protected int starvationPeriod;
  protected int speed;
  protected int starving;
  protected int harga;
  protected int degree;
  protected int radius;
  protected int moveTimer;
  protected Point posisi;
  protected String jenis;

  public abstract void hunt(Aquarium aquarium);

  public abstract void produce(Aquarium aquarium);

  public abstract int getProduceTime();

  public abstract void setProduceTime(int produceTime);

  public abstract int getMaxProduceTime();

  /**
   * Berenang ke suatu titik.
   *
   * @param x posisi tujuan
   * @param speed ikan
   */
  public void swimto(Point x, int speed) {
    Point temp = this.getPosisi();
    double rad = Math.atan2((double) (x.getY() - temp.getY()),
        (double) (x.getX() - temp.getX()));
    int deg = (int) ((rad * 180) / pi);
    swim(deg, speed);
  }

  /**
   * Berenang dengan derajat sebesar degree.
   *
   * @param degree renang ikan
   * @param speed ikan
   */
  public void swim(int degree, int speed) {
    double rad = (double) degree * pi / 180.0;
    Point temp = getPosisi();
    int absisNew =
        temp.getX() + (int) (speed * Math.cos(rad) * ((maxMoveTime) - getMoveTime()) / 15);
    int ordinatNew =
        temp.getY() + (int) (speed * Math.sin(rad) * (maxMoveTime - getMoveTime()) / 15);
    if (absisNew < temp.getX()) {
      rightDirect = false;
    } else {
      rightDirect = true;
    }
    int absis = absisNew;
    int ordinat = ordinatNew;
    if (absis <= 30) {
      absis = 30;
    }
    if (absis >= 870) {
      absis = 870;
    }
    if (ordinat <= 50) {
      ordinat = 50;
    }
    if (ordinat >= 600) {
      ordinat = 600;
    }
    temp.setX(absis);
    temp.setY(ordinat);
    setPosisi(temp);
  }

  /**
   * Mencoba Berenang.
   */
  public void trySwim() {
    Random rand = new Random();
    int randomNumber = Math.abs(rand.nextInt() % 360);
    this.setStarvationPeriod(this.getStarvationPeriod() - 1);
    if (this.getMoveTime() <= 0) {
      int randoms = (randomNumber % 40);
      int directions = (randomNumber % 2);
      if (directions >= 1) {
        randoms *= -1;
      }
      this.setDegree((this.getDegree() + randoms * randomNumber) % 360);
      this.setMoveTime(this.getMaxMove());
    }
    this.swim(this.getDegree(), this.getSpeed());
    this.setStarving(this.getStarving() - 1);
  }

  /**
   * Mencoba memproduksi koin.
   *
   * @param aquarium aquarium
   */
  public void tryProduce(Aquarium aquarium) {
    if (this.getProduceTime() < 0) {
      this.produce(aquarium);
      this.setProduceTime(this.getMaxProduceTime());
    }
    this.setProduceTime(this.getProduceTime() - 1);
    this.setProduceTime(this.getProduceTime() - 1);
  }

  /**
   * Ubah arah gerak.
   */
  public void changeDirection() {
    rightDirect = !rightDirect;
  }

  /**
   * Membandingkan objek dengan id.
   *
   * @param object benda
   */
  @Override
  public int compareTo(Object object) {
    Fish fish = (Fish) object;
    if (fish.getId() == getId()) {
      return 0;
    } else if (fish.getId() < getId()) {
      return -1;
    } else {
      return 1;
    }
  }

  /**
   * getter starving.
   *
   * @return starvationPeriod dari ikan
   */
  public boolean isStarving() {
    return starvationPeriod <= 0;
  }

  /**
   * getter arah.
   *
   * @return rightDirect arah ikan
   */
  public boolean isFaceRight() {
    return rightDirect;
  }

  /**
   * getter movetime.
   *
   * @return moveTimer ikan
   */
  public int getMoveTime() {
    return moveTimer;
  }

  /**
   * setter move time.
   *
   * @param moveTimer ikan
   */
  public void setMoveTime(int moveTimer) {
    this.moveTimer = moveTimer;
  }

  /**
   * getter id.
   *
   * @return id ikan
   */
  public int getId() {
    return id;
  }

  /**
   * getter posisi.
   *
   * @return posisi ikan
   */
  public Point getPosisi() {
    return posisi;
  }

  /**
   * setter posisi.
   *
   * @param posisi ikan
   */
  public void setPosisi(Point posisi) {
    this.posisi = posisi;
  }

  /**
   * getter starvationperiod.
   *
   * @return starvation period
   */
  public int getStarvationPeriod() {
    return starvationPeriod;
  }

  /**
   * setter starvationperiod ikan.
   *
   * @param starvationPeriod ikan
   */
  public void setStarvationPeriod(int starvationPeriod) {
    this.starvationPeriod = starvationPeriod;
  }

  /**
   * getter speed.
   *
   * @return speed ikan
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * getter harga.
   *
   * @return harga ikan
   */
  public int getHarga() {
    return harga;
  }

  /**
   * setter harga.
   *
   * @param harga ikan
   */
  public void setHarga(int harga) {
    this.harga = harga;
  }

  /**
   * getter starving.
   *
   * @return starving waktu ikan mati
   */
  public int getStarving() {
    return starving;
  }

  /**
   * setter starving waktu mati ikan.
   *
   * @param starving atribut starving ikan
   */
  public void setStarving(int starving) {
    this.starving = starving;
  }

  /**
   * getter sudut renang ikan.
   *
   * @return degree ikan
   */
  public int getDegree() {
    return degree;
  }

  /**
   * setter sudut renang.
   *
   * @param degree ikan
   */
  public void setDegree(int degree) {
    this.degree = degree;
  }

  /**
   * getter maximum move.
   *
   * @return maxMoveTime ikan
   */
  public int getMaxMove() {
    return maxMoveTime;
  }

  /**
   * getter radius makan.
   *
   * @return radius ikan
   */
  public double getRadius() {
    return radius;
  }

  /**
   * setter radius makan.
   *
   * @param radius radius ikan
   */
  public void setRadius(int radius) {
    this.radius = radius;
  }

  /**
   * getter jenis ikan.
   *
   * @return jenis ikan
   */
  public String getJenis() {
    return jenis;
  }

  /**
   * setter jenis ikan.
   *
   * @param jenis jenis ikan
   */
  public void setJenis(String jenis) {
    this.jenis = jenis;
  }
}