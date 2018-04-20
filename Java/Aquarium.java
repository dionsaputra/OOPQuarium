import java.lang.*;
import java.util.*;

public class Aquarium {

  private LinkedList<ObjekMati> listObjekMati;
  private LinkedList<Fish> listIkan;
  private LinkedList<Pet> listPet;
  private int time;
  private final int length;
  private final int width;

  public Aquarium() {
    length = 100;
    width = 100;
  }

  public Aquarium(int length, int width) {
    length = length;
    width = width;
  }

  public Aquarium(int l, int w, LinkedList<ObjekMati> lo, LinkedList<Fish> li, LinkedList<Pet> lp) {
    length = l;
    width = w;
    listObjekMati = lo;
    listIkan = li;
    listPet = lp;
  }

  public void addObject(Fish fish) {
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

  public void removeObject(Pet pet) {
    listObjekMati.remove(pet);
  }

  public void action() {
    Random rand = new Random();
    for (int i = 0; i < listIkan.totalElmt(); i++) {
      Fish temp = listIkan.get(i);
      if (tempoint.getStarving() <= 0) {
        RemoveObject(listIkan.get(i));
      } else {
        int count = 0; 
        int countguppy = 0;
        for (int j = 0; j < listObjekMati.totalElmt(); j++) {
          if (listObjekMati.get(j).getJenis() == "Makanan Ikan") {
            count++;
          }
        }
        for (int j = 0; j < listIkan.totalElmt(); j++) {
          if (listIkan.get(j).getJenis() == "Guppy") {
            countguppy++;
          }
        }
        if (tempoint.getJenis() == "Guppy") {
          if (tempoint.getStarvationPeriod() > 0 || count == 0) {
            tempoint.setStarvationPeriod(tempoint.getStarvationPeriod() - 1);
            if (tempoint.getMoveTime() <= 0) {
              //srand(time(NULL));
              int randoms = (rand.nextInt(40) % 40);
              int directions = (rand.nextInt(4) % 2);
              if (directions >= 1) {
                randoms *= -1;
              }
              tempoint.setDegree((tempoint.getDegree() + randoms) % 360);
              tempoint.setMoveTime(tempoint.getMAXMOVE());
            }
            tempoint.swim(tempoint.setDegree(), tempoint.getSpeed());
            tempoint.setStarving(tempoint.getStarving() - 1);
          } else {
            tempoint.eat(this);
          }
        } else {
          if (tempoint.getStarvationPeriod() > 0 || countguppy == 0) {
            tempoint.setStarvationPeriod(tempoint.getStarvationPeriod() - 1);
            if (tempoint.getMoveTime() <= 0) {
              //srand(time(NULL));
              int randoms = (rand.nextInt(360) % 360);

              int directions = (rand.nextInt(4) % 2);
              if (directions != 0) {
                randoms *= -1;
              }
              tempoint.setDegree((tempoint.getDegree() + randoms) % 360);
              tempoint.setMoveTime(tempoint.getMAXMOVE());
            }
            tempoint.swim(tempoint.getDegree(), tempoint.getSpeed());
            tempoint.setStarving(tempoint.getStarving() - 1);
          } else {
            tempoint.eat(this);
          }
        }
        tempoint.setMoveTime(tempoint.getMoveTime() - 1);

        //produce
        if (tempoint.getJenis() == "Guppy") {
          if (tempoint.getProduceTime() < 0) {
            tempoint.produce(this);
            tempoint.setProduceTime(tempoint.getMaxProduceTime());
          }
          //cout<<temp->getProduceTime()<<" ampun\n";
          tempoint.setProduceTime(tempoint.getProduceTime() - 1);
        }
      }
    }
    for (int i = 0; i < listPet.totalElmt(); i++) {
      listPet.get(i).eat(this);
      //cout<<"EAT TELAH DIJALANKAN\n";
    }
    for (int i = 0; i < listObjekMati.totalElmt(); i++) {
      listObjekMati.get(i).turun(this);
    }
  }

  public int isEdge(Point point, double radius) {
    if (Math.abs(point.getOrdinat() - width) < radius) {
      return 2;
    } else if (point.getOrdinat() < radius) {
      return 4;
    } else if (Math.abs(point.getAbsis() - length) < radius) {
      return 1;
    } else if (point.getAbsis() < radius) {
      return 3;
    } else {
      return 0;
    }
  }

  public LinkedList<ObjekMati> getListObjekMati() {
    return listObjekMati;
  }

  public LinkedList<Fish> getListIkan() {
    return listIkan;
  }

  public LinkedList<Pet> getListPet() {
    return listPet;
  }

  public int getlength() {
    return length;
  }

  public int getwidth() {
    return width;
  }

  public int getTime() {
    return time;
  }

}
