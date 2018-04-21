import java.lang.Math;

public abstract class Fish implements Comparable {

  private final double pi = 3.14159265;
  private int maxStarving;
  private int maxStarvationPeriod;
  private int maxMoveTime;
  private static int counter = 0;
  private int id;
  private boolean rightDirect;
  private int starvationPeriod;
  private int speed;
  private int starving;
  private int harga;
  private int degree;
  private Point posisi;
  private String jenis;

  public abstract void eat(Aquarium aquarium);

  public abstract void produce(Aquarium aquarium);

  public abstract int getProduceTime();

  public abstract int getMaxProduceTime();

  public abstract void setProduceTime(int produceTime);

  public void swimto(Point x, int speed) {
    Point temp = this.getPosisi();
    double rad = atan2((double)(x.getOrdinat() - temp.getOrdinat()),
        (double)(x.getAbsis() - temp.getAbsis()));
    int deg = (rad * 180) / pi;
    swim(deg, speed);
  }

  public void swim(int degree, int speed) {
    double rad = (double) degree * pi / 180.0;
    Point temp = getPosisi();
    int absisNew =
        temp.getAbsis() + (speed * cos(rad) * ((maxMoveTime) - getMoveTime()) / 15);
    int ordinatNew =
        temp.getOrdinat() + (speed * sin(rad) * (maxMoveTime - getMoveTime()) / 15);
    if (absisNew < temp.getAbsis()) {
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

    temp.setAbsis(absis);
    temp.setOrdinat(ordinat);

    setPosisi(temp);
  }

  //Change Direction
  public void change_direction() {
    rightDirect = !rightDirect;
  }

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

  //Cek lapar
  public boolean isStarving() {
    return starvationPeriod <= 0;
  }

  //Cek arah
  public boolean isFaceRight() {
    return rightDirect;
  }

  //Setter Getter
  public int getMoveTime() {
    return moveTimer;
  }

  public int getId() {
    return id;
  }

  public Point getPosisi() {
    return posisi;
  }

  public int getStarvationPeriod() {
    return starvationPeriod;
  }

  public int getSpeed() {
    return speed;
  }

  public int getHarga() {
    return harga;
  }

  public int getStarving() {
    return starving;
  }

  public int getDegree() {
    return degrees;
  }

  public int getMaxMove() {
    return maxMoveTime;
  }

  public double getRadius() {
    return radius;
  }

  public String getJenis() {
    return jenis;
  }

  public void setDegree(int degree) {
    degree = degree;
  }

  public void setMoveTime(int moveTimer) {
    this.moveTimer = moveTimer;
  }

  public void setHarga(int harga) {
    this.harga = harga;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public void setJenis(String jenis) {
    this.jenis = jenis;
  }

  public void setPosisi(Point posisi) {
    this.posisi = posisi;
  }

  public void setStarvationPeriod(int starvationPeriod) {
    this.starvationPeriod = starvationPeriod;
  }

  public void setStarving(int starving) {
    this.starving = starving;
  }
}