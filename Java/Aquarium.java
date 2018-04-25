//CARA COMPILE
//javac Aquarium.java Fish.java Guppy.java Piranha.java ObjekMati.java Koin.java MakananIkan.java Pet.java Point.java
import java.lang.Math;
public class Aquarium {

  private LinkedList<ObjekMati> listObjekMati = new LinkedList<ObjekMati> ();
  private LinkedList<Fish> listIkan = new LinkedList<Fish>();
  private LinkedList<Pet> listPet = new LinkedList<Pet>();
  private int time;
  private int dasar;
  private final int length;
  private final int width;

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
    System.out.println(fish.getPosisi().getAbsis());
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
   * Menghitung Banyaknya Guppy.
   */
  public int countGuppy(){
    int countguppy = 0;
    for (int j = 0; j < listIkan.totalElmt(); j++) {
      if (listIkan.get(j).getJenis().equals("Guppy")) {
        countguppy++;
      }
    }
    return countguppy;
  }

  /**
   * Menghitung Banyaknya Makanan ikan.
   */
  public int countFood(){
    int countfood = 0; 
    for (int j = 0; j < listObjekMati.totalElmt(); j++) {
      if (listObjekMati.get(j).getJenis().equals("Makanan Ikan")) {
        countfood++;
      }
    }
    return countfood;
  }

  /**
   * Mengendalikan kehidupan ikan.
   */
  public void controlFish(){
    for (int i = 0; i < listIkan.totalElmt(); i++) {
      Fish tempoint = listIkan.get(i);
      if (tempoint.getStarving() <= 0) {
        removeObject(listIkan.get(i));
      } else {
        if (tempoint.getJenis().equals("Guppy")) {
          if (tempoint.getStarvationPeriod() > 0 || countFood()==0 ) {
            tempoint.trySwim();
          } else {
            tempoint.hunt(this);
          }
          tempoint.tryProduce(this);
        } else {  //Piranha
          if (tempoint.getStarvationPeriod() > 0 || countGuppy()==0) {
            tempoint.trySwim();
          } else {
            tempoint.hunt(this);
          }
        }
        tempoint.setMoveTime(tempoint.getMoveTime() - 1);
      }
    }
  }

  /**
   * Mengendalikan kehidupan pet.
   */
  public void controlPet(){
    for (int i = 0; i < listPet.totalElmt(); i++) {
      listPet.get(i).life(this);
    }
  }

  /**
   * Mengendalikan kehidupan benda mati.
   */
  public void controlDeadObject(){
    for (int i = 0; i < listObjekMati.totalElmt(); i++) {
      listObjekMati.get(i).turun(this);
    }
  }

  /**
   * Mengendalikan kehidupan dalam akuarium.
   */
  public void action() {
    controlFish();
    controlPet();
    controlDeadObject();
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

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  public int getTime() {
    return time;
  }

  public int getDasar(){
    return 6 * (length / 7);
  }
}
