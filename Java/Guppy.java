public class Guppy {

  private int growthStep;
  private int foodCapacity;
  private int produceTime
  private int growthTImer;
  private int produceTimer;

  public Guppy() {
    MAX_STARVING = 500;
    MAX_STARVATION_PERIOD = 200;
    MAX_MOVE_TIME = 50;
    growthTImer = 6;
    produceTimer = 100;
    id = counter++;
    speed = 1;
    harga = 50;
    growthStep = 1;
    foodCapacity = 0;
    right_direct = false;
    degrees = 90;
    radius = 20;
    jenis = "Guppy";
    setStarvationPeriod(MAX_STARVATION_PERIOD);
    setStarving(MAX_STARVING);
    setMoveTime(MAX_MOVE_TIME);
    setProduceTime(getMaxProduceTime());
  }

  public void eat(Aquarium aquarium) {
    boolean existFood = false;
    boolean eatFood = false;
    double radMin = 1e7; //untuk nyimpen jarak terdekat
    int i = 0;
    int idx;
    Point idxGuppy = getPosisi();
    Point pointKejar;
    while (i < aq.getListObjekMati().totalElmt()) {
      if (aq.getListObjekMati().get(i).getJenis() == "Makanan Ikan") {
        existFood = true;
        Point pointMakanan = aq.getListObjekMati().get(i).getPosisi();
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
      if (foodCapacity >= growthTImer) { //next growth
        foodCapacity = 0;
        if (growthStep < 3) {
          growthStep++;
          harga += harga;
        }
      }
      //Update hungry time
      //real_eat
      setStarvationPeriod(MAX_STARVATION_PERIOD);
      setStarving(MAX_STARVING);
      //ilangin makanan ikan
      aq.RemoveObject(aq.getListObjekMati().get(idx));
    } else {
      setStarving(getStarving() - 1);
    }
  }

  public void produce(Aquarium aquarium) {
    Koin koin = new Koin(50 * growthStep, getPosisi());
    aq.AddObject(koin);
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

  public getMaxProduceTime() {
    return produceTimer;
  }

  public void setFoodCapacity(int x) {
    foodCapacity = x;
  }

  public void setProduceTime(int x) {
    produceTime = x;
  }

}