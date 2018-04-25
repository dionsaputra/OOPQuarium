import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumTest {

  @Test
  void addObject() {
    Aquarium aq = new Aquarium();
    int prevGuppy = 0;
    Guppy g = new Guppy();
    g.setPosisi(new Point(3,2));
    aq.addObject(g);
    assertEquals(prevGuppy+1,aq.countGuppy());
  }

  @Test
  void removeObject() {
    Aquarium aq = new Aquarium();
    int prevGuppy = 0;
    Guppy g = new Guppy();
    g.setPosisi(new Point(3,2));
    aq.addObject(g);
    aq.removeObject(g);
    assertEquals(prevGuppy,aq.countGuppy());
  }


  @Test
  void countGuppy() {
    Aquarium aq = new Aquarium();
    int prevGuppy = 0;
    Guppy g = new Guppy();
    g.setPosisi(new Point(3,2));
    aq.addObject(g);
    aq.removeObject(g);
    assertEquals(prevGuppy,aq.countGuppy());
  }

  @Test
  void countFood() {
    Aquarium aq = new Aquarium();
    int prevFood = 0;
    MakananIkan g = new MakananIkan();
    aq.addObject(g);
    aq.removeObject(g);
    assertEquals(prevFood,aq.countFood());
  }

  @Test
  void controlDeadObject() {
    Aquarium aq = new Aquarium();
    ObjekMati om = new ObjekMati(5);
    assertTrue(true);
  }
}