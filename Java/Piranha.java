public class Piranha extends Fish {

  private int latestFood;

  public Piranha() {
    maxStarving = 500;
    maxStarvationPeriod = 200;
    maxMoveTime = 70;

    degree = 30;
    jenis = "Piranha";
    latestFood = 0;
    radius = 20;
    id = counter++;
    rightDirect = false;
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);
    setMoveTime(maxMoveTime);
    speed = 2;
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
      if (aquarium.getListIkan().get(i).getJenis() == "Guppy") {
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
      if (radMin <= getRadius()) {
        eatFood = true;
      } else {
        swimto(pointKejar, getSpeed());
        setStarving(getStarving() - 1);
      }
    }

    // eat guppu
    if (eatFood) {
      //Update hungry time
      setStarvationPeriod(maxStarvationPeriod);
      setStarving(maxStarving);
      //ilangin guppy
      Guppy temp = (Guppy) aquarium.getListIkan().get(idx);
      setLast(temp.getHarga() * (temp.getGrowthStep() + 1)); //untuk makan
      aquarium.removeObject(aquarium.getListIkan().get(idx));
      produce(aquarium);
    } else {
      setStarving(getStarving() - 1);
    }
  }

  public void produce(Aquarium aquarium) {
    Koin koin = new Koin(getLast(), getPosisi());
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

  public void setLast(int latestFood) {
    latestFood = latestFood;
  }
}