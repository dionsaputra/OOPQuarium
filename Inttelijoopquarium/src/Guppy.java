public class Guppy extends Fish implements Consumer {

  private int growthStep;
  private int foodCapacity;
  private int produceTime;
  private int growthTimer;
  private int produceTimer;

  /**
   * Konstruktor default guppy.
   */
  public Guppy() {
    maxStarving = 500;
    maxStarvationPeriod = 200;
    maxMoveTime = 70;
    growthTimer = 6;
    produceTimer = 250;
    id = counter++;
    speed = 1;
    harga = 50;
    growthStep = 1;
    foodCapacity = 0;
    rightDirect = false;
    degree = 180;
    radius = 20;
    jenis = "Guppy";
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);
    setMoveTime(maxMoveTime);
    setProduceTime(getMaxProduceTime());
  }

  /**
   * Kejar makanan ikan.
   * @param radMin radius makanan terdekat
   * @param pointKejar posisi target
   * @return True if makanan udah bisa dimakan
   */
  public boolean chaseFood(double radMin,Point pointKejar) {
    if (radMin <= getRadius()) {
      return true;
    } else {
      swimto(pointKejar, getSpeed());
      setStarving(getStarving() - 1);
      return false;
    }
  }

  /**
   * makan makanan ikan.
   * @param aquarium ubah isi aquarium
   * @param idx indeks makanan ikan di list
   */
  public void eat(Aquarium aquarium,int idx) {
    foodCapacity = foodCapacity + 1;
    if (foodCapacity >= growthTimer) { //next growth
      foodCapacity = 0;
      if (growthStep < 3) {
        growthStep++;
        this.harga += harga;
      }
    }
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);
    aquarium.removeObject(aquarium.getListObjekMati().get(idx));
  }

  /**
   * Makan makanan ikan.
   * @param aquarium Aquarium ikan
   */
  public void hunt(Aquarium aquarium) {
    boolean existFood = false;
    boolean eatFood = false;
    double radMin = 1e7; //untuk nyimpen jarak terdekat
    int i = 0;
    int idx = 0;
    Point idxGuppy = getPosisi();
    Point pointKejar = new Point();
    while (i < aquarium.getListObjekMati().totalElmt()) {
      if (aquarium.getListObjekMati().get(i).getJenis().equals("Makanan Ikan")) {
        existFood = true;
        Point pointMakanan = aquarium.getListObjekMati().get(i).getPosisi();
        double jarak = idxGuppy.hitungJarak(pointMakanan);
        if (jarak < radMin) {
          radMin = jarak;
          idx = i;
          pointKejar = pointMakanan;
        }
      }
      i++;
    }

    if (existFood) {
      eatFood = chaseFood(radMin,pointKejar);
    }

    if (eatFood) {
      System.out.println("I'M HUNGRY :(");
      eat(aquarium,idx);
    } else {
      setStarving(getStarving() - 1);
    }
  }

  /**
   * produce koin.
   * @param aquarium ubah isi aquarium
   */
  public void produce(Aquarium aquarium) {
    Point posisiKoin = new Point(getPosisi().getAbsis(), getPosisi().getOrdinat());
    Koin koin = new Koin(50 * growthStep, posisiKoin);
    aquarium.addObject(koin);
  }

  /**
   * setter growth ikan.
   */
  public void nextGrowth() {
    growthStep = growthStep + 1;
  }

  /**
   * getter growth step ikan.
   * @return growthStep ikan
   */
  public int getGrowthStep() {
    return growthStep;
  }

  /**
  * getter kapasitas makanan ikan untuk tumbuh.
  * @return foodCapacity kapasitas makan
  */
  public int getFoodCapacity() {
    return foodCapacity;
  }

  /**
   * getter kapasitas makanan ikan untuk tumbuh.
   * @return produceTime untuk produksi koin
   */
  public int getProduceTime() {
    return produceTime;
  }

  /**
   * getter id ikan.
   * @return id ikan
   */
  public int getId() {
    return id;
  }

  /**
   * getter produceTimer ikan.
   * @return produceTimer ikan
   */
  public int getMaxProduceTime() {
    return produceTimer;
  }

  /**
   * setter kapasitas makan ikan.
   * @param x kapasitas makan
   */
  public void setFoodCapacity(int x) {
    foodCapacity = x;
  }

  /**
   * setter waktu produksi koin dari ikan.
   * @param x producetime
   */
  public void setProduceTime(int x) {
    produceTime = x;
  }
}