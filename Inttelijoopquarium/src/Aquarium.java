//CARA COMPILE
//javac Aquarium.java Fish.java Guppy.java Piranha.java
// ObjekMati.java Koin.java MakananIkan.java Pet.java model.Point.java

import java.util.ArrayList;

public class Aquarium {

  private final int length;
  private ArrayList<ObjekMati> listObjekMati = new ArrayList<>();
  private ArrayList<Fish> listIkan = new ArrayList<>();
  private ArrayList<Pet> listPet = new ArrayList<>();

  public Aquarium(int length) {
    this.length = length;
  }

  public void addObject(Fish fish) {
    System.out.println(fish.getPosisi().getX());
    listIkan.add(fish);
  }

  public void addObject(ObjekMati objekMati) {
    listObjekMati.add(objekMati);
  }

  public void addObject(Pet pet) {
    listPet.add(pet);
  }

  public void removeObject(Fish fish) {
    listIkan.remove(fish);
  }

  public void removeObject(ObjekMati objekMati) {
    listObjekMati.remove(objekMati);
  }

  public int countGuppy() {
    int countguppy = 0;
    for (int j = 0; j < listIkan.size(); j++) {
      if (listIkan.get(j).getJenis().equals("Guppy")) {
        countguppy++;
      }
    }
    return countguppy;
  }

  public int countFood() {
    int countfood = 0;
    for (int j = 0; j < listObjekMati.size(); j++) {
      if (listObjekMati.get(j).getJenis().equals("Makanan Ikan")) {
        countfood++;
      }
    }
    return countfood;
  }

  public void controlFish() {
    for (int i = 0; i < listIkan.size(); i++) {
      Fish tempoint = listIkan.get(i);
      if (tempoint.getStarving() <= 0) {
        removeObject(listIkan.get(i));
      } else {
        if (tempoint.getJenis().equals("Guppy")) {
          if (tempoint.getStarvationPeriod() > 0 || countFood() == 0) {
            tempoint.trySwim();
          } else {
            tempoint.hunt(this);
          }
          tempoint.tryProduce(this);
        } else {  //Piranha
          if (tempoint.getStarvationPeriod() > 0 || countGuppy() == 0) {
            tempoint.trySwim();
          } else {
            tempoint.hunt(this);
          }
        }
        tempoint.setMoveTime(tempoint.getMoveTime() - 1);
      }
    }
  }

  public void controlPet() {
    for (int i = 0; i < listPet.size(); i++) {
      listPet.get(i).life(this);
    }
  }


  public void controlDeadObject() {
    for (int i = 0; i < listObjekMati.size(); i++) {
      listObjekMati.get(i).turun(this);
    }
  }

  public void action() {
    controlFish();
    controlPet();
    controlDeadObject();
  }

  public ArrayList<ObjekMati> getListObjekMati() {
    return listObjekMati;
  }

  public ArrayList<Fish> getListIkan() {
    return listIkan;
  }

  public ArrayList<Pet> getListPet() {
    return listPet;
  }


  public int getDasar() {
    return 6 * (length / 7);
  }
}
