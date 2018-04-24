public class Guppy extends Fish {

  private int growthStep;
  private int foodCapacity;
  private int produceTime;
  private int growthTimer;
  private int produceTimer;

  public Guppy() {
    maxStarving = 500;
    maxStarvationPeriod = 200;
    maxMoveTime = 50;
    growthTimer = 6;
    produceTimer = 100;
    id = counter++;
    speed = 1;
    harga = 50;
    growthStep = 1;
    foodCapacity = 0;
    rightDirect = false;
    degree = 90;
    radius = 20;
    jenis = "Guppy";
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);
    setMoveTime(maxMoveTime);
    setProduceTime(getMaxProduceTime());
  }

  public void eat(Aquarium aquarium) {
    boolean existFood = false;
    boolean eatFood = false;
    double radMin = 1e7; //untuk nyimpen jarak terdekat
    int i = 0;
    int idx = 0;
    Point idxGuppy = getPosisi();
    Point pointKejar = new Point();
    while (i < aquarium.getListObjekMati().totalElmt()) {
      if (aquarium.getListObjekMati().get(i).getJenis() == "Makanan Ikan") {
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
    // Cek mau dimakan atau dikejar
    if (existFood) {
      if (radMin <= getRadius()) {
        eatFood = true;
      } else {
        swimto(pointKejar, getSpeed());
        setStarving(getStarving() - 1);
      }
    }

    // Makan makanan
    if (eatFood) {
      //printf("makan\n");

      foodCapacity = foodCapacity + 1;
      //If its a time to growth
      if (foodCapacity >= growthTimer) { //next growth
        foodCapacity = 0;
        if (growthStep < 3) {
          growthStep++;
          harga += harga;
        }
      }
      //Update hungry time
      //real_eat
      setStarvationPeriod(maxStarvationPeriod);
      setStarving(maxStarving);
      //ilangin makanan ikan
      aquarium.removeObject(aquarium.getListObjekMati().get(idx));
    } else {
      setStarving(getStarving() - 1);
    }
  }

  public void produce(Aquarium aquarium) {
    Koin koin = new Koin(50 * growthStep, getPosisi());
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