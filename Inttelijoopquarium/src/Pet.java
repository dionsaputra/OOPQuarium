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

  public void eat(Aquarium aquarium) {
    boolean existCoin = false;
    int i = 0;

    while (i < aquarium.getListObjekMati().totalElmt() && !existCoin) {
      if (aquarium.getListObjekMati().get(i).getJenis() == "Koin") {
        existCoin = true;
      } else {
        i++;
      }
    }

    if (existCoin) {
      int j = 0;
      boolean existCoinOnGround = false;
      while (j < aquarium.getListObjekMati().totalElmt() && !existCoinOnGround) {
        boolean isKoin = aquarium.getListObjekMati().get(j).getJenis() == "Koin";
        boolean isDasar = aquarium.getListObjekMati().get(j).isDasar(aquarium);
        if (isKoin && isDasar) {
          existCoinOnGround = true;
        } else {
          j++;
        }
      }

      if (existCoinOnGround) {
        double nearestHorizontally = aquarium.getWidth() + 1000000;
        int idx;
        for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
          boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis() == "Koin";
          boolean isDasar = aquarium.getListObjekMati().get(idx).isDasar(aquarium);
          boolean isLower = getPosisi().hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi())
              < nearestHorizontally;
          if (isKoin && isDasar && isLower) {
            nearestHorizontally = getPosisi()
                .hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi());
            break;
          }
        }

        if (radius >= nearestHorizontally) {
          Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
          setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
          aquarium.removeObject(aquarium.getListObjekMati().get(idx));
        } else {
          Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),
              aquarium.getLength());
          walkTo(goal);
        }
      } else {
        double nearestVertically = aquarium.getLength() + 1000000;
        int idx;

        for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
          boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis() == "Koin";
          boolean isLower =
              aquarium.getLength() - aquarium.getListObjekMati().get(idx).getPosisi().getOrdinat()
                  < nearestVertically;
          if (isKoin && isLower) {
            nearestVertically =
                aquarium.getLength() - aquarium.getListObjekMati().get(idx).getPosisi().getOrdinat();
            break;
          }
        }

        if (radius >= nearestVertically) {
          Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
          setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
          aquarium.removeObject(aquarium.getListObjekMati().get(idx));
        } else {
          Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),
              aquarium.getLength());
          walkTo(goal);
        }
      }
    }
  }

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
