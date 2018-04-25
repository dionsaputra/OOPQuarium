public class Piranha extends Fish {

  private int latestFood;

  public Piranha() {
    maxStarving = 500;
    maxStarvationPeriod = 200;
    maxMoveTime = 70;

    degree = 30;
    jenis = "Piranha";
    latestFood = 0;
    radius = 15;
    id = counter++;
    rightDirect = false;
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);
    setMoveTime(maxMoveTime);
    speed = 2;
  }

  public boolean chaseFood(double radMin,Point pointKejar){
    if (radMin <= getRadius()) {
      return true;
    } else {
      swimto(pointKejar, getSpeed());
      setStarving(getStarving() - 1);
      return false;
    }
  }

  public void biteFish(Aquarium aquarium,int idx){
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);

    Guppy temp = (Guppy) aquarium.getListIkan().get(idx);
    setLast(temp.getHarga() * (temp.getGrowthStep() + 1)); //untuk makan
    aquarium.removeObject(aquarium.getListIkan().get(idx));
    this.produce(aquarium);
  }

  public void eat(Aquarium aquarium) {
    boolean existFood = false;
    boolean eatFood = false;
    double radMin = 1e7;
    int i = 0;
    int idx = 0;
    Point idxPiranha = getPosisi();
    Point pointKejar = new Point();

    // check food exist
    while (i < aquarium.getListIkan().totalElmt()) {
      if (aquarium.getListIkan().get(i).getJenis().equals("Guppy")) {
        existFood = true;
        Point pointMakanan = aquarium.getListIkan().get(i).getPosisi();
        double jarak = idxPiranha.hitungJarak(pointMakanan);
        if (jarak < radMin) {
          radMin = jarak;
          idx = i;
          pointKejar = pointMakanan;
        }
      }
      i++;
    }

    // check walk to food or eat it
    if (existFood) {
      eatFood = chaseFood(radMin,pointKejar);
    }

    // eat guppy
    if (eatFood) {
      System.out.println("SEE ME");
      biteFish(aquarium, idx);
    } else {
      setStarving(getStarving() - 1);
    }
  }

  public void produce(Aquarium aquarium) {
    Point posisiKoin = new Point(getPosisi().getAbsis(), getPosisi().getOrdinat());
    Koin koin = new Koin(getLast(), posisiKoin);
    aquarium.addObject(koin);
  }

  public int getProduceTime() {
    return 1;
  }

  public int getMaxProduceTime() {
    return 1;
  }

  public void setProduceTime(int produceTime) {
    // do nothing
  }

  public int getLast() {
    return latestFood;
  }

  public int getId() {
    return id;
  }

  public void setLast(int latestFood) {
    this.latestFood = latestFood;
  }
}