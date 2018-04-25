import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

  @Test
  void getId() {
    Pet p = new Pet(5,2,new Point(3,2));
    assertEquals(13,p.getId());
    System.out.println("getId success");
  }

  @Test
  void getFaceRight() {
    Pet p = new Pet(5,2,new Point(3,2));
    p.setFaceRight(true);
    assertTrue(p.getFaceRight());
    System.out.println("getFaceRight success");
  }

  @Test
  void setFaceRight() {
    Pet p = new Pet(5,2,new Point(3,2));
    p.setFaceRight(true);
    assertTrue(p.getFaceRight());
    System.out.println("setFaceRight success");
  }

  @Test
  void getRadius() {
    Pet p = new Pet(5,2,new Point(3,2));
    assertEquals(2,p.getRadius());
    System.out.println("getRadius success");
  }

  @Test
  void setRadius() {
    Pet p = new Pet(5,2,new Point(3,2));
    p.setRadius(9);
    assertEquals(9,p.getRadius());
    System.out.println("setRadius success");
  }

  @Test
  void getTotalMoney() {
    Pet p = new Pet(5,2,new Point(3,2));
    p.setTotalMoney(34);
    assertEquals(34,p.getTotalMoney());
    System.out.println("getTotalMoney success");
  }

  @Test
  void setTotalMoney() {
    Pet p = new Pet(5,2,new Point(3,2));
    p.setTotalMoney(34);
    assertEquals(34,p.getTotalMoney());
    System.out.println("setTotalMoney success");
  }

  @Test
  void getPosisi() {
    Pet p = new Pet(5,2,new Point(3,2));
    assertTrue(p.getPosisi().compareTo(new Point(3,2)) == 0);
    System.out.println("getPosisi success");
  }

  @Test
  void setPosisi() {
    Pet p = new Pet(5,2,new Point(3,2));
    p.setPosisi(new Point(2,5));
    assertTrue(p.getPosisi().compareTo(new Point(2,5)) == 0);
    System.out.println("setPosisi success");
  }

  @Test
  void walkTo() {
    Pet p = new Pet(5,2,new Point(3,2));
    Point pLama = new Point(p.getPosisi().getAbsis(),p.getPosisi().getOrdinat());
    p.walkTo(new Point(6,3));
    assertTrue(p.getPosisi().compareTo(pLama) != 0);
    System.out.println("walkTo success");
  }

  @Test
  void existCoin(){
    Point posisiPet = new Point(100,100);
    Pet pet = new Pet(1,1,posisiPet);
    Aquarium aq = new Aquarium();
    System.out.println("cek existCoin");
    assertEquals(false,pet.existCoin(aq));
    System.out.println("cek existCoin valid");

    Point pointKoin = new Point(50,50);
    Koin koin = new Koin(10,pointKoin);
    aq.addObject(koin);

    System.out.println("cek existCoin");
    assertEquals(true,pet.existCoin(aq));
    System.out.println("cek existCoin valid");
  }

  @Test
  void existCoinOnGround(){
    Aquarium aq = new Aquarium(100,700);
    Point posisiKoin1 = new Point(0,0);
    Koin koin1 = new Koin(100,posisiKoin1);
    aq.addObject(koin1);

    Point posisiPet = new Point(100,100);
    Pet pet = new Pet(1,1,posisiPet);

    System.out.println("cek existCoinOnGround");
    assertEquals(false,pet.existCoinOnGround(aq));
    System.out.println("cek existCoinOnGround valid");

    Point posisiKoin2 = new Point(0,aq.getDasar());
    Koin koin2 = new Koin(100,posisiKoin2);
    aq.addObject(koin2);
    System.out.println("cek existCoinOnGround");
    assertEquals(true,pet.existCoinOnGround(aq));
    System.out.println("cek existCoinOnGround valid");
  }

  @Test
  void nearestHorizontalKoin(){
    Aquarium aq = new Aquarium(100,100);
    Point p1 = new Point(0,50);
    Point p2 = new Point(100,50);
    Koin k1 = new Koin(10,p1);
    Koin k2 = new Koin(10,p2);
    aq.addObject(k1);
    aq.addObject(k2);

    Point p3 = new Point(60,50);
    Pet pet = new Pet(1,1,p3);

    int idx = pet.nearestHorizontalKoin(aq);
    assertEquals(1,idx);
  }

  @Test
  void nearestVerticalKoin(){
    Aquarium aq = new Aquarium(100,100);
    Point p1 = new Point(0,50);
    Point p2 = new Point(100,60);
    Koin k1 = new Koin(10,p1);
    Koin k2 = new Koin(10,p2);
    aq.addObject(k1);
    aq.addObject(k2);

    Point p3 = new Point(100,100);
    Pet pet = new Pet(1,1,p3);

    int idx = pet.nearestVerticalKoin(aq);
    assertEquals(1,idx);
  }

  @Test
  void isInRadius() {
    Aquarium aq = new Aquarium(100,100);
    Point p1 = new Point(1,1);
    Point p2 = new Point(100,100);
    Koin k1 = new Koin(10,p1);
    Koin k2 = new Koin(10,p2);
    aq.addObject(k1);
    aq.addObject(k2);

    Point p3 = new Point(0,0);
    Pet pet = new Pet(1,20,p3);

    assertEquals(true,pet.isInRadius(aq,0));
    assertEquals(false,pet.isInRadius(aq,1));
  }

  @Test
  void isAbsisInRadius() {
    Aquarium aq = new Aquarium(100,100);
    Point p1 = new Point(50,50);
    Point p2 = new Point(100,100);
    Koin k1 = new Koin(10,p1);
    Koin k2 = new Koin(10,p2);
    aq.addObject(k1);
    aq.addObject(k2);

    Point p3 = new Point(40,0);
    Pet pet = new Pet(1,20,p3);

    assertEquals(true,pet.isAbsisInRadius(aq,0));
    assertEquals(false,pet.isAbsisInRadius(aq,1));
  }

  @Test
  void eat() {
    Aquarium aq = new Aquarium(100,100);
    Point p1 = new Point(50,50);
    Point p2 = new Point(100,100);
    Koin k1 = new Koin(10,p1);
    Koin k2 = new Koin(20,p2);
    aq.addObject(k1);
    aq.addObject(k2);

    Point p3 = new Point(40,0);
    Pet pet = new Pet(1,20,p3);

    pet.eat(aq,0);
    assertEquals(10,pet.getTotalMoney());
    assertEquals(1,aq.getListObjekMati().totalElmt());
  }

  @Test
  void compareTo() {
    Pet p = new Pet(5,2,new Point(3,2));
    assertTrue(p.compareTo(p) == 0);
    Pet p1 = new Pet(5,2,new Point(3,2));
    assertTrue(p.compareTo(p1) != 0);
    System.out.println("compareTo success");
  }
}