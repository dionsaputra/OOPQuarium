import java.lang.Math;

public class Aquarium {

  private LinkedList<ObjekMati> listObjekMati;
  private LinkedList<Fish> listIkan;
  private LinkedList<Pet> listPet;
  private int time;
  private final int length; //ATAS - BAWAH
  private final int width; //KIRI-KANAN
  /**
   * Constructor Aquarium, mengassign nilai length dan width menjadi 100.
   */

  public Aquarium() {
    length = 100;
    width = 100;
  }
  /**
   * Constructor Aquarium, mengassign nilai length dan width sesuai masukan.
   * @param length ukuran length (ATAS-BAWAH) akuarium
   * @param width ukuran width (KIRI-KANAN) akuarium
   */

  public Aquarium(int length, int width) {
    this.length = length;
    this.width = width;
  }

  /**
   * Constructor Aquarium dengan mengassign nilai length,
   * width, dan list benda-benda yang ada di aquarium.
   * @param length ukuran length (ATAS-BAWAH) akuarium
   * @param width ukuran width (KIRI-KANAN) akuarium
   * @param listObjekMati list dari objek mati yang ingin dimasukkan ke akuarium
   * @param listIkan list dari ikan yang ingin dimasukkan ke akuarium
   * @param listPet list dair pet yang ingin dimasukkan ke akuarium
   */
  public Aquarium(int length, int width, LinkedList<ObjekMati> listObjekMati,
                  LinkedList<Fish> listIkan, LinkedList<Pet> listPet) {
    this.length = length;
    this.width = width;
    this.listObjekMati = listObjekMati;
    this.listIkan = listIkan;
    this.listPet = listPet;
  }

  /**
   * Menambahkan sebuah objek bertipe Fish ke dalam listIkan.
   * @param fish ikan yang ingin dimasukkan ke dalam list ikan
   */

  public void addObject(Fish fish) {
    listIkan.add(fish);
  }
  /**
   * Menambahkan sebuah objek bertipe objekMati ke dalam listObjekMati.
   * @param objekMati objek mati yang ingin dimasukkan ke dalam list  objek mati
   */

  public void addObject(ObjekMati objekMati) {
    listObjekMati.add(objekMati);
  }
  /**
   * Menambahkan sebuah objek bertipe Pet ke dalam listPet.
   * @param pet pet yang ingin dimasukkan ke dalam list pet
   */

  public void addObject(Pet pet) {
    listPet.add(pet);
  }
  /**
   * Menghapus suatu ikan pada list ikan.
   * @param fish ikan yang ingin dihapus dari list ikan
   */

  public void removeObject(Fish fish) {
    listIkan.remove(fish);
  }
  /**
   * Menghapus suatu objekMati pada liatObjekMati.
   * @param objekMati objek mati yang ingin dihapus list objek mati.
   */

  public void removeObject(ObjekMati objekMati) {
    listObjekMati.remove(objekMati);
  }
  /**
   * Menghapus suatu pet dari listPet.
   * @param pet pet yang ingin dihapus dari list pet
   */

  public void removeObject(Pet pet) {
    listPet.remove(pet);
  }
  /**
   * Mengendalikan kehidupan dalam akuarium.
   */

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
  /**
   * Mengecek apakah suatu titik merupakan ujung dari akuarium
   * dalam radius tertentu.
   * @param point sebuah point yang ingin dicek
   * @param radius jarak ketelitian P terhadap edge
   * @return 0 BUKAN UJUNG 1 ATAS 2 KANAN 3 BAWAH 4 KIRI
   */

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
