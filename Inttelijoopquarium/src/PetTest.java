import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

  @Test
  void getId() {
    Pet p = new Pet(5,2,new Point(3,2));
    assertEquals(7,p.getId());
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
    Aquarium aq1 = new Aquarium();
    Point point = new Point(50,50);
    Koin koin = new Koin(10,point);
    aq1.addObject(koin);
    System.out.println("cek existCoin");
    assertEquals(true,);


  }

  @Test
  void eat() {

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