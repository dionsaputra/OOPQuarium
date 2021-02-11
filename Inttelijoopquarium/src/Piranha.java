import model.Point;

public class Piranha extends Fish implements Consumer {

  private int latestFood;

  /**
   * Konstruktor default piranha.
   */
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

  /**
   * Kejar makanan ikan.
   *
   * @param radMin radius makanan terdekat
   * @param pointKejar posisi target
   * @return True if makanan udah bisa dimakan
   */
  public boolean chaseFood(double radMin, Point pointKejar) {
    if (radMin <= getRadius()) {
      return true;
    } else {
      swimto(pointKejar, getSpeed());
      setStarving(getStarving() - 1);
      return false;
    }
  }

  /**
   * makan guppy.
   *
   * @param aquarium ubah isi aquarium
   * @param idx indeks guppy di list
   */
  public void eat(Aquarium aquarium, int idx) {
    setStarvationPeriod(maxStarvationPeriod);
    setStarving(maxStarving);

    Guppy temp = (Guppy) aquarium.getListIkan().get(idx);
    setLast(temp.getHarga() * (temp.getGrowthStep() + 1)); //untuk makan
    aquarium.removeObject(aquarium.getListIkan().get(idx));
    this.produce(aquarium);
  }

  /**
   * Makan makanan ikan.
   *
   * @param aquarium Aquarium ikan
   */
  public void hunt(Aquarium aquarium) {
    boolean existFood = false;
    boolean eatFood = false;
    double radMin = 1e7;
    int i = 0;
    int idx = 0;
    Point idxPiranha = getPosisi();
    Point pointKejar = new Point();

    // check food exist
    while (i < aquarium.getListIkan().size()) {
      if (aquarium.getListIkan().get(i).getJenis().equals("Guppy")) {
        existFood = true;
        Point pointMakanan = aquarium.getListIkan().get(i).getPosisi();
        double jarak = idxPiranha.distance(pointMakanan);
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
      eatFood = chaseFood(radMin, pointKejar);
    }

    // eat guppy
    if (eatFood) {
      System.out.println("SEE ME");
      eat(aquarium, idx);
    } else {
      setStarving(getStarving() - 1);
    }
  }

  /**
   * produce koin.
   *
   * @param aquarium ubah isi aquarium
   */
  public void produce(Aquarium aquarium) {
    Point posisiKoin = new Point(getPosisi().getX(), getPosisi().getY());
    Koin koin = new Koin(getLast(), posisiKoin);
    aquarium.addObject(koin);
  }

  /**
   * getter kapasitas makanan ikan untuk tumbuh.
   *
   * @return foodCapacity kapasitas makan
   */
  public int getProduceTime() {
    return 1;
  }

  /**
   * setter waktu produksi koin dari ikan.
   *
   * @param produceTime waktu produce
   */
  public void setProduceTime(int produceTime) {
    // do nothing
  }

  /**
   * getter kapasitas makanan ikan untuk tumbuh.
   *
   * @return produceTime untuk produksi koin
   */
  public int getMaxProduceTime() {
    return 1;
  }

  /**
   * getter last food yang dimakan sama piranha.
   *
   * @return latestFood untuk produksi koin
   */
  public int getLast() {
    return latestFood;
  }

  /**
   * setter latestfood dari piranha.
   *
   * @param latestFood ikan terakhir yang dimakan
   */
  public void setLast(int latestFood) {
    this.latestFood = latestFood;
  }

  /**
   * getter id piranha.
   *
   * @return id piranha
   */
  public int getId() {
    return id;
  }
}