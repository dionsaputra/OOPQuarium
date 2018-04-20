public class Piranha {

  private int latestFood;

  public Piranha() {
    MAX_STARVING = 500;
    MAX_STARVATION_PERIOD = 200;
    MAX_MOVE_TIME = 70;

    speed = 2;
    radius = 20;
    degrees = 30;
    latestFood = 0;
    jenis = "Piranha";
    right_direct = false;
    setStarving(MAX_STARVING);
    setMoveTime(MAX_MOVE_TIME);
    setStarvationPeriod(MAX_STARVATION_PERIOD);

  }

  public void eat(Aquarium aquarium) {
    bool existFood = false;
    bool eatFood = false;
    double radMin = 1e7;
    int i = 0;
    int idx;
    Point idxPiranha = getPosisi();
    Point pointKejar;
    while (i < aq.getListIkan().totalElmt()) {
      if (aq.getListIkan().get(i).getJenis() == "Guppy") {
        existFood = true;
        Point pointMakanan = aq.getListIkan().get(i).getPosisi();
        double jarak = idxPiranha.hitungJarak(pointMakanan);
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

    // Makan guppy
    if (eatFood) {
      //Update hungry time
      setStarvationPeriod(MAX_STARVATION_PERIOD);
      setStarving(MAX_STARVING);
      //ilangin guppy
      Guppy temp = aq.getListIkan().get(idx);
      setLast(temp.getHarga() * (temp.getGrowthStep() + 1)); //untuk makan
      aq.RemoveObject(aq.getListIkan().get(idx));
      produce(aq);
    } else {
      setStarving(getStarving() - 1);
    }
  }

  public void produce(Aquarium aquarium) {
    Koin koin = new Koin(getLast(), getPosisi());
    aq.AddObject(koin);
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