public class Guppy extends Fish {

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
    produceTimer = 60;
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

  public boolean chaseFood(double radMin,Point pointKejar){
    if (radMin <= getRadius()) {
      System.out.println("REALLY HUNGRY :((");
      return true;
    } else {
      swimto(pointKejar, getSpeed());
      setStarving(getStarving() - 1);
      return false;
    }
  }

  public void biteFood(Aquarium aquarium,int idx){
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
   * Makan.
   * @param aquarium Aquarium ikan
   */
  public void eat(Aquarium aquarium) {
    boolean existFood = false, eatFood = false;
    double radMin = 1e7; //untuk nyimpen jarak terdekat
    int i = 0, idx = 0;
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
      biteFood(aquarium,idx);
    } else {
      setStarving(getStarving() - 1);
    }
  }

  public void produce(Aquarium aquarium) {
    Point posisiKoin = new Point(getPosisi().getAbsis(), getPosisi().getOrdinat());
    Koin koin = new Koin(50 * growthStep, posisiKoin);
    aquarium.addObject(koin);
  }

  //Growing
  public void nextGrowth() {
    growthStep = growthStep + 1;
  }

  //Getter Setter
  public int getGrowthStep() {
    return growthStep;
  }

  public int getFoodCapaty() {
    return foodCapacity;
  }

  public int getProduceTime() {
    return produceTime;
  }

  public int getId() {
    return id;
  }


  public int getMaxProduceTime() {
    return produceTimer;
  }

  public void setFoodCapacity(int x) {
    foodCapacity = x;
  }

  public void setProduceTime(int x) {
    produceTime = x;
  }

}