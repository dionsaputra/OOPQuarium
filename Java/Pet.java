public class Pet implements Comparable{

  private static int counter = 0;
  private boolean faceRight;
  private int id;
  private int kecepatan;
  private int radius;
  private int totalMoney;
  private Point posisi;

  public Pet(int kecepatan, int radius, Point posisi) {
    this.faceRight = true;
    this.id = counter++;
    this.kecepatan = kecepatan;
    this.radius = radius;
    this.totalMoney = 0;
    this.posisi = posisi;
  }

  public int getId() {
    return id;
  }

  public boolean getFaceRight() {
    return faceRight;
  }

  public void setFaceRight(boolean faceRight) {
    this.faceRight = faceRight;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public int getTotalMoney() {
    return totalMoney;
  }

  public void setTotalMoney(int totalMoney) {
    this.totalMoney = totalMoney;
  }

  public Point getPosisi() {
    return posisi;
  }

  public void setPosisi(Point posisi) {
    this.posisi = posisi;
  }

  public void walkTo(Point goal) {
    int dx = kecepatan;

    if (goal.getAbsis() < posisi.getAbsis()) {
      faceRight = false;
      dx = -1 * dx;
    } else if (goal.getAbsis() == posisi.getAbsis()) {
      dx = 0;
    } else {
      faceRight = true;
    }

    Point point = this.getPosisi();
    point.setAbsis(point.getAbsis() + dx);
    this.setPosisi(point);
  }

  private boolean existCoin(Aquarium aq){
    boolean existCoin = false;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++){
      if (aq.getListObjekMati().get(i).getJenis().equals("Koin")){
        existCoin = true; 
        break;
      }
    }
    return existCoin;
  }

  private boolean existCoinOnGround(Aquarium aq){
    boolean existCoinOnGround = false;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++){
      boolean isKoin = aq.getListObjekMati().get(i).getJenis().equals("Koin");
      boolean isDasar = aq.getListObjekMati().get(i).isDasar(aq);
      if (isKoin && isDasar){
        existCoinOnGround = true;
        break;
      }
    }
    return existCoinOnGround;
  }

  private int nearestHorizontalFood(Aquarium aq){
    double dist = 1000000;
    int idx = 0;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++){
      boolean isKoin = aq.getListObjekMati().get(i).getJenis().equals("Koin");
      int ordinatObjMati = aq.getListObjekMati().get(idx).getPosisi().getOrdinat();
      int absisObjMati = aq.getListObjekMati().get(idx).getPosisi().getAbsis();
      if (ordinatObjMati == this.getPosisi().getOrdinat() && isKoin){
        if (Math.abs(absisObjMati - this.getPosisi().getAbsis()) < dist){
          dist = Math.abs(absisObjMati - this.getPosisi().getAbsis());
          idx = i;
          break;
        }
      }
    }
    return idx;
  }

  private int nearestVerticalFood(Aquarium aq){
    double dist = 1000000;
    int idx = 0;
    for (int i = 0; i < aq.getListObjekMati().totalElmt(); i++){
      boolean isKoin = aq.getListObjekMati().get(i).getJenis().equals("Koin");
      int ordinatObjMati = aq.getListObjekMati().get(idx).getPosisi().getOrdinat();
      if (Math.abs(ordinatObjMati = this.getPosisi().getOrdinat()) < dist && isKoin){
        dist = Math.abs(ordinatObjMati = this.getPosisi().getOrdinat());
        idx = i;
        break;
      }
    }
    return idx;
  }

  private boolean isInRadius(Aquarium aq, int idx){
    Point posisiObjMati = aq.getListObjekMati().get(idx).getPosisi();
    return this.getPosisi().hitungJarak(posisiObjMati) <= radius;
  }

  private boolean isInAbsis(Aquarium aq, int idx){
    int absisObjMati = aq.getListObjekMati().get(idx).getPosisi().getAbsis();
    return this.getPosisi().getAbsis() == absisObjMati;
  }

  private void eat(Aquarium aq, int idx){
    Koin koin = (Koin) aq.getListObjekMati().get(idx);
    setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
    aq.removeObject(aq.getListObjekMati().get(idx));
  }

  public void life(Aquarium aq){
    if (existCoin(aq)){
      if (existCoinOnGround(aq)){
        System.out.println(" HERE \n");
        int idx = nearestHorizontalFood(aq);
        if (isInRadius(aq,idx)){
          eat(aq,idx);
        } else {
          walkTo(aq.getListObjekMati().get(idx).getPosisi());
        }
      } else {
        int idx = nearestVerticalFood(aq);
        if (isInRadius(aq,idx)){
          eat(aq,idx);
        } else {
          if (!isInAbsis(aq,idx)){
            walkTo(aq.getListObjekMati().get(idx).getPosisi());
          }
        }
      }
    } 
  }

  // private getIdNearest
  // public void eat(Aquarium aquarium) {
  //   if (existCoin(aquarium)){
  //     if (existCoinOnGround(aquarium)){
  //     if (existCoinOnGround) {
  //       double nearestHorizontally = aquarium.getWidth() + 1000000;
  //       int idx;
  //       for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
  //         boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis().equals("Koin");
  //         boolean isDasar = aquarium.getListObjekMati().get(idx).isDasar(aquarium);
  //         boolean isLower = getPosisi().hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi())
  //             < nearestHorizontally;
  //         if (isKoin && isDasar && isLower) {
  //           nearestHorizontally = getPosisi()
  //               .hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi());
  //           break;
  //         }
  //       }

  //       if (radius >= nearestHorizontally) {
    
  //       } else {
  //         Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),
  //             aquarium.getLength());
  //         walkTo(goal);
  //       }
  //     } else {
  //       double nearestVertically = aquarium.getLength() + 1000000;
  //       int idx;

  //       for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
  //         boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis().equals("Koin");
  //         boolean isLower =
  //             aquarium.getLength() - aquarium.getListObjekMati().get(idx).getPosisi().getOrdinat()
  //                 < nearestVertically;
  //         if (isKoin && isLower) {
  //           nearestVertically =
  //               aquarium.getLength() - aquarium.getListObjekMati().get(idx).getPosisi().getOrdinat();
  //           break;
  //         }
  //       }

  //       if (radius >= nearestVertically) {
  //         Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
  //         setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
  //         aquarium.removeObject(aquarium.getListObjekMati().get(idx));
  //       } else {
  //         Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),
  //             aquarium.getLength());
  //         walkTo(goal);
  //       }
  //     }
  //   }
  // }

  //   // if (existCoin) {
  //   //   System.out.println("#################  EXIST COIN ##################");
  //   //   int j = 0;
  //   //   boolean existCoinOnGround = false;
  //   //   while (j < aquarium.getListObjekMati().totalElmt() && !existCoinOnGround) {
  //   //     boolean isKoin = aquarium.getListObjekMati().get(j).getJenis().equals("Koin");
  //   //     boolean isDasar = aquarium.getListObjekMati().get(j).isDasar(aquarium);
  //   //     if (isKoin && isDasar) {
  //   //       existCoinOnGround = true;
  //   //     } else {
  //   //       j++;
  //   //     }
  //   //   }

  //   //   if (existCoinOnGround) {
  //   //     System.out.println("#################  EXIST COIN ON GROUND ##################");
  //   //     double nearestHorizontally = aquarium.getWidth() + 1000000;
  //   //     int idx;
  //   //     for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
  //   //       boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis().equals("Koin");
  //   //       boolean isDasar = aquarium.getListObjekMati().get(idx).isDasar(aquarium);
  //   //       boolean isLower = getPosisi().hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi())
  //   //           < nearestHorizontally;
  //   //       if (isKoin && isDasar && isLower) {
  //   //         nearestHorizontally = getPosisi()
  //   //             .hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi());
  //   //         break;
  //   //       }
  //   //     }
  //   //     System.out.println("############ KEJAR KOIN ###########" + idx);
  //   //     if (radius >= nearestHorizontally) {
  //   //       Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
  //   //       setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
  //   //       aquarium.removeObject(aquarium.getListObjekMati().get(idx));
  //   //     } else {
  //   //       Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),
  //   //           aquarium.getLength());
  //   //       walkTo(goal);
  //   //     }
  //   //   } else {
  //   //     double nearestVertically = aquarium.getLength() + 1000000;
  //   //     int idx;

  //   //     for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
  //   //       boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis().equals("Koin");
  //   //       boolean isLower =
  //   //           aquarium.getLength() - aquarium.getListObjekMati().get(idx).getPosisi().getOrdinat()
  //   //               < nearestVertically;
  //   //       if (isKoin && isLower) {
  //   //         nearestVertically =
  //   //             aquarium.getLength() - aquarium.getListObjekMati().get(idx).getPosisi().getOrdinat();
  //   //         break;
  //   //       }
  //   //     }

  //   //     if (radius >= nearestVertically) {
  //   //       Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
  //   //       setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
  //   //       aquarium.removeObject(aquarium.getListObjekMati().get(idx));
  //   //     } else {
  //   //       Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),
  //   //           aquarium.getLength());
  //   //       walkTo(goal);
  //   //     }
  //   //   }
  //   // }
  // }

  public int compareTo(Object pet) {
    Pet p = (Pet) pet;
    if(p.getId() == id){
      return 0;
    }
    else{
      return 1;
    }
  }
}
